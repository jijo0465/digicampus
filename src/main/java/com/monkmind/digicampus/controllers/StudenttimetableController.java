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
	 	List<WeekDay> weekDays = new ArrayList<>();
	 	weekDays.add(WeekDay.MONDAY);
	 	weekDays.add(WeekDay.TUESDAY);
	 	weekDays.add(WeekDay.WEDNESDAY);
	 	weekDays.add(WeekDay.THURSDAY);
	 	weekDays.add(WeekDay.FRIDAY);
	 	for(int i=0;i<35;i++){
	 		periods.add(new Period());
	 		studentTimeTable.addPeriod(new Period());
		}
	 	model.addAttribute("weekDays",weekDays);
	 	model.addAttribute("config",new TimeTableConfig());
	    model.addAttribute("studentTimeTable", studentTimeTable);
	    model.addAttribute("gradeList",gradeservice.listAll());
	    model.addAttribute("subjectList",subjectService.findall());
	    return "fragments/dc-components/dc-screen-layout/dc-student-timetable/dc-student-timetable-add.html::dc-student-timetable-add";
	}

	@PostMapping("/saveTimeTable")
	public String saveTimeTable(@ModelAttribute StudentTimeTable studentTimeTable,Model model) {
		//System.out.println("HIEHIHIHIEIHI");
		for(Period p : studentTimeTable.getPeriods()){
			System.out.println(p.getSubject().getName());
			System.out.println(p.getWeekDay());
		}
		for(Period p : studentTimeTable.getPeriods()){
			p.setStudentTimeTable(studentTimeTable);

		}
		studentTimetableService.save(studentTimeTable);
		return "fragments/dc-components/dc-screen-layout/dc-student-timetable/dc-student-timetable-confirm.html::dc-student-timetable-confirm";
	}

	@RequestMapping(path = "/edit/studenttimetable")
	public String timetableEdit(Model model) {
		model.addAttribute("gradeList",gradeservice.listAll());
		model.addAttribute("subjectList",subjectService.findall());
	     return "fragments/dc-components/dc-screen-layout/dc-student-timetable/dc-student-timetable-edit::dc-student-timetable-edit";
	}
	
	@PostMapping(path = "edit/studenttimetable/{id}")
	public String updateTimetable(@PathVariable SubjectSchema id,Model model) {
		model.addAttribute("studentTimetable",studentTimetableService.findBySchemaId(id));
	    return "fragments/dc-components/dc-screen-layout/dc-student-timetable/dc-student-timetable-edit02::dc-student-timetable";
	}

	@RequestMapping("/display/studenttimetable")
	public String displayTimetable(Model model)
	{
		model.addAttribute("gradeList",gradeservice.listAll());
		model.addAttribute("subjectList",subjectService.findall());
		return "fragments/dc-components/dc-screen-layout/dc-student-timetable/dc-student-timetable-display::dc-student-timetable-display";
	}
	@PostMapping(path = "display/studenttimetable/{id}")
	public String viewTimetable(@PathVariable SubjectSchema id,Model model) {
		model.addAttribute("studentTimetable",studentTimetableService.findBySchemaId(id));
		return "fragments/dc-components/dc-screen-layout/dc-student-timetable/dc-student-timetable-display02::dc-student-display";
	}


}
