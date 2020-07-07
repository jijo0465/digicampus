/*created by:shijina
  created on:19/5/2020
    */
package com.monkmind.digicampus.controllers;

import java.util.ArrayList;
import java.util.List;

import com.monkmind.digicampus.configurations.TimeTableConfig;
import com.monkmind.digicampus.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.monkmind.digicampus.command.StudentTimeTableCommand;
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
	
	 @GetMapping("/addstudenttimetable")
	public String timetableForm(Model model) {
	 	StudentTimeTable studentTimeTable = new StudentTimeTable();
	 	List<Period> periods = new ArrayList<>();
	 	List<String> weekDays = new ArrayList<>();
	 	weekDays.add("MONDAY");
	 	weekDays.add("TUESDAY");
	 	weekDays.add("WEDNESDAY");
	 	weekDays.add("THURSDAY");
	 	weekDays.add("FRIDAY");
	 	for(int i=0;i<35;i++){
	 		periods.add(new Period());
	 		studentTimeTable.addPeriod(new Period());
		}
	 	model.addAttribute("weekDays",weekDays);
	 	model.addAttribute("config",new TimeTableConfig());
	    model.addAttribute("studentTimeTable", studentTimeTable);
	    model.addAttribute("gradeList",gradeservice.listAll());
	    model.addAttribute("subjectList",subjectService.findall());
	    return "fragments/dc-components/dc-screen-layout/dc-student-timetable/dc-student-timetable-add.html::dc-schema-add";
	}

	@RequestMapping("/saveTimeTable")
	public String saveTimeTable(@ModelAttribute StudentTimeTable studentTimeTable,Model model) {
		//System.out.println("HIEHIHIHIEIHI");
		for(Period p : studentTimeTable.getPeriods()){
			System.out.println(p.getSubject().getName());
		}
		studentTimetableService.save(studentTimeTable);
//	 	System.out.println(studentTimetable.getPeriods().size());
	   // StudentTimeTable timetable=studentTimetableService.save(studentTimetable);
	//    model.addAttribute("studentTimetable",timetable);
		return "fragments/dc-components/dc-screen-layout/dc-student-timetable/dc-student-timetable-add.html::dc-schema-add";
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
	/*@RequestMapping("/timetable")
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
	}*/
}
