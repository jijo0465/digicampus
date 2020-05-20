package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.NonTStaffAttendance;

import com.monkmind.digicampus.services.NonTStaffAttendanceService;


import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class NonTStaffAttendanceController {
	private final  NonTStaffAttendanceService nontstaffAttendanceService;
	
	
	 @RequestMapping("/nonteachingattendanceform")
		public String NonTStaffAttendanceForm(Model model) {
		    model.addAttribute("nstaffattendance", new NonTStaffAttendance());
		    return "nonteachingattendance_form";
		}
	@PostMapping
	@RequestMapping("/nonteachingattendance")
	public String createAttendance(@ModelAttribute NonTStaffAttendance nontstaffattendance ,Model model) {
		NonTStaffAttendance attendance=nontstaffAttendanceService.save(nontstaffattendance);
		model.addAttribute("nstaffattendance",attendance);
	    return "nonteachingattendancedisplay";
	
	    
	    

}

}