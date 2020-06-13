/*created by:shijina
  created on:19/5/2020
    */
package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.Period;
import com.monkmind.digicampus.models.StudentTimeTable;
import com.monkmind.digicampus.models.Subject;
import com.monkmind.digicampus.models.WeekDay;
import com.monkmind.digicampus.repositories.GradeRepository;
import com.monkmind.digicampus.services.GradeService;
import com.monkmind.digicampus.services.PeriodService;
import com.monkmind.digicampus.services.StudentTimetableService;
import com.monkmind.digicampus.services.SubjectService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class StudenttimetableController {
	
	private final StudentTimetableService studentTimetableService;
	//private final GradeRepository graderepository;
	private final GradeService gradeservice;
	private final PeriodService periodService;
	private final SubjectService subjectService;
	
	 @RequestMapping("/studenttimetableform")
	public String timetableForm(Model model) {
	    model.addAttribute("studentTimetable", new StudentTimeTable());
	    return "studenttimetable_form";
	}

	@PostMapping
	@RequestMapping("/timetableinsert")
	public String createTimeTable(@ModelAttribute StudentTimeTable studentTimetable,Model model) {
	    StudentTimeTable timetable=studentTimetableService.save(studentTimetable);
	    model.addAttribute("studentTimetable",timetable);
	    return "index";
	}
	
	
	 @RequestMapping("/studenttimetableformdisplay")
		public String timetableDisplay(Model model) {
		 List<StudentTimeTable> timetables=studentTimetableService.findAll();
		    model.addAttribute("timetables",timetables);
		    return "studenttimetabledisplay";
		}
	@RequestMapping("/e/{id}")
	public String timetableEdit(@PathVariable String id,Model model) {
		System.out.println(id);
	    StudentTimeTable studentTimetable = studentTimetableService.getById(new Long(id));
	    model.addAttribute("studentTimetable",studentTimetable);
	     return "updatestudenttimetable";
	}
	
	@PostMapping
	@RequestMapping("/updatetimetable/{id}")
	public String InsertTimetable(@ModelAttribute StudentTimeTable studentTimetable,Model model) {
		studentTimetableService.save(studentTimetable);
	    return "index";
	}

	@RequestMapping("/timedele/{id}")
	public String deleteStudentTimetable(@PathVariable Long id,Model model)
	{
		studentTimetableService.delete(id);
		return "redirect:/";
		
	}
	@RequestMapping("/timetable")
	public String outtimetable() {
		Long id=(long) 2;
		Grade savedgrade=gradeservice.getGradeById(id);
		List<StudentTimeTable> timetable=studentTimetableService.findByGrade(savedgrade);
		for (StudentTimeTable studentTimeTable : timetable) {
			System.out.println(studentTimeTable.getDay());
			List<Period> periods=periodService.getByStudentTimeTable(studentTimeTable);
			for (Period period : periods) {
				System.out.println(period.getStartngTime());
				List<Subject> subjects=subjectService.getByPeriodId(period);
				for (Subject subject : subjects) {
					System.out.println(subject.getName());
				}
			}
		}
		return("/index");
	}
}
