
/*created by:shijina
 * created on:23/05/2020
 * 
 */
 package com.monkmind.digicampus.controllers;
 

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.NonTStaffAttendance;
//import com.monkmind.digicampus.models.Student;
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
	    return "index";
	}

	 @RequestMapping("/nonteachingattendancedisplay")
		public String NonTStaffAttendanceDisplayForm(Model model) {
		 List<NonTStaffAttendance> listNonStaffs=nontstaffAttendanceService.listAll();
		    model.addAttribute("listNonStaffs",listNonStaffs);
		    return "nonteachingattendancedisplay";
		}

	 @RequestMapping("/changing/{id}")
		public String nonstaffEdit(@PathVariable String id,Model model) {
			System.out.println(id);
			NonTStaffAttendance nonStaffAttendance = nontstaffAttendanceService.getId(new Long(id));
		    model.addAttribute("nonStaffAttendance",nonStaffAttendance);
		     return "updatenontattendance";
		}
		
		@PostMapping
		@RequestMapping("/updatenonattendance/{id}")
		public String insertNonattendance(@ModelAttribute NonTStaffAttendance nontstaffattendance ,Model model) {
			nontstaffAttendanceService.save(nontstaffattendance);
		    return "index";
		}
		@RequestMapping("/deleting/{id}")
		public String deleteNonteachingAttendance(@PathVariable Long id,Model model)
		{
			nontstaffAttendanceService.delete(id);
			return "redirect:/";
			
		}



}