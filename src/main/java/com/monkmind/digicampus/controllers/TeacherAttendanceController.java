package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	@PostMapping("/teacherattendanceinsert")
	public String createAttendance(@ModelAttribute TeacherAttendance teacherattendance ,Model model) {
		TeacherAttendance teacherz= teacherattendanceService.save(teacherattendance);
		model.addAttribute("teacherattendance",teacherz);
	    return "redirect:/";
	}
	
	
	
	
	@RequestMapping("/teacherattendancedisplay")
	public String displayAttendance(@ModelAttribute TeacherAttendance teacherattendance ,Model model) {
		List<TeacherAttendance> teacherlists=teacherattendanceService.listAll();
		model.addAttribute("teacherlists",teacherlists);
		teacherattendanceService.save(teacherattendance);
	    return "teacherattendancedisplay";
	}
	
	@RequestMapping("/c/{id}")
	public String attendanceTeacher(@PathVariable String id,Model model) {
	System.out.println(id);
    TeacherAttendance teacherTime = teacherattendanceService.getId(new Long(id));
    model.addAttribute("teacherattendance",teacherTime);
     return "updateteacherattendance";
		}

	@PostMapping
	@RequestMapping("/updateteacherattendance/{id}")
	public String InsertTeacherattendance(@ModelAttribute TeacherAttendance teacherattendance,Model model) {
	teacherattendanceService.save(teacherattendance);
    return "index";
}
	@RequestMapping("/lt/{id}")
	public String deleteTeacherattendance(@PathVariable Long id,Model model)
	{
		teacherattendanceService.delete(id);
		return "redirect:/";
		
	}
}
