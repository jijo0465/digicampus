package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.monkmind.digicampus.models.StudentAttendance;
import com.monkmind.digicampus.models.TeacherAttendance;
//import com.monkmind.digicampus.services.AttendanceService;
import com.monkmind.digicampus.services.TeacherAttendanceService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class TeacherAttendanceController {
	private final  TeacherAttendanceService teacherattendanceService;
	
	
	 @RequestMapping("/teacherattendanceform")
		public String TeacherAttendanceForm(Model model) {
		    model.addAttribute("teacherattendance", new TeacherAttendance());
		    return "teachingattendance";
		}
	@PostMapping
	@RequestMapping("/teacherattendance")
	public String createAttendance(@ModelAttribute TeacherAttendance teacherattendance ,Model model) {
	    teacherattendanceService.save(teacherattendance);
	    return "index";
	

}
}
