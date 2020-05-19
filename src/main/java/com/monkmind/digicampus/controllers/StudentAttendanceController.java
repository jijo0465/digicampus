package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.models.StudentAttendance;
import com.monkmind.digicampus.services.StudentAttendanceService;

import lombok.AllArgsConstructor;
@Controller
@AllArgsConstructor
/*author:haritha
created date:18/5/2020
*/
public class StudentAttendanceController {
	private final StudentAttendanceService studentattendanceService;
	
	
	 @RequestMapping("/studentattendanceform")
		public String studentAttendanceForm(Model model) {
		    model.addAttribute("student_attendance", new StudentAttendance());
		    return "studentattendance";
		}
	@PostMapping
	@RequestMapping("/studentattendance")
	public String createAttendance(@ModelAttribute StudentAttendance studentattendance ,Model model) {
	    studentattendanceService.save(studentattendance);
	    return "index";
	

}

}