/*created by:shijina
  created on:19/5/2020
    */
package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.SchoolBus;
import com.monkmind.digicampus.models.StudentTimeTable;
import com.monkmind.digicampus.services.StudentTimetableService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class StudenttimetableController {
	
	private final StudentTimetableService studentTimetableService;
	
	 @RequestMapping("/studenttimetableform")
	public String timetableForm(Model model) {
	    model.addAttribute("studentTimetable", new StudentTimeTable());
	    return "studenttimetable_form";
	}

	@PostMapping
	@RequestMapping("/timetableinsert")
	public String createTimeTable(@ModelAttribute StudentTimeTable studentTimetable,Model model) {
	    studentTimetableService.save(studentTimetable);
	    return "studenttimetabledisplay";
	}
	
	@RequestMapping("/ei/{day}")
	public String timetableEdit(@PathVariable String day,Model model) {
		System.out.println(day);
	    StudentTimeTable studentTimetable = studentTimetableService.getByDay(new Long(day));
	    model.addAttribute("studentTimetable",studentTimetable);
	     return "updatestudenttimetable";
	}
	
	@PostMapping
	@RequestMapping("/updatetimetable/{day}")
	public String InsertTimetable(@ModelAttribute StudentTimeTable studentTimetable,Model model) {
		studentTimetableService.save(studentTimetable);
	    return "index";
	}


}
