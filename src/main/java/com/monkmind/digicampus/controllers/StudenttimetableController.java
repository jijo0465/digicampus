package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.monkmind.digicampus.models.StudentTimeTable;
import com.monkmind.digicampus.services.StudentTimetableService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class StudenttimetableController {
	
	private final StudentTimetableService studentTimetableService;
	
	/*author:shijina
    created date:19/5/2020
    */
    
    
    @RequestMapping("/studenttimetableform")
	public String timetableForm(Model model) {
	    model.addAttribute("StudentTimeTable", new StudentTimeTable());
	    return "studenttimetable_form";
	}

	@PostMapping
	@RequestMapping("/timetableinsert")
	public String createTimeTable(@ModelAttribute StudentTimeTable studentTimeTable,Model model) {
	    studentTimetableService.save(studentTimeTable);
	    return "index";
	}

}
