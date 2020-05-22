/*created by:shijina
created on:20/5/2020
*/


package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.models.StudentAttendance;
import com.monkmind.digicampus.models.StudentTimeTable;
import com.monkmind.digicampus.services.StudentAttendanceService;

import lombok.AllArgsConstructor;
@Controller
@AllArgsConstructor

public class StudentAttendanceController {
	private final StudentAttendanceService studentattendanceService;
	
	
	 @RequestMapping("/studentattendanceform")
		public String studentAttendanceForm(Model model) {
		    model.addAttribute("studentattendance", new StudentAttendance());
		    return "studentattendance";
		}
	@PostMapping
	@RequestMapping("/studentattendance")
	public String createAttendance(@ModelAttribute StudentAttendance studentattendance ,Model model) {
		StudentAttendance student=  studentattendanceService.save(studentattendance);
		 model.addAttribute("studentattendance",student);
	    return "studentattendancedisplay";
	}
	
	@RequestMapping("/b/{id}")
	public String attendanceEdit(@PathVariable String id,Model model) {
		System.out.println(id);
	    StudentAttendance studentattendance = studentattendanceService.getId(new Long(id));
	    model.addAttribute("studentattendance",studentattendance);
	     return "updatestudenttimetable";
	}
	
	@PostMapping
	@RequestMapping("/updatestudentattendance/{id}")
	public String InsertSattendance(@ModelAttribute StudentAttendance studentattendance,Model model) {
		studentattendanceService.save(studentattendance);
	    return "index";
	}

}