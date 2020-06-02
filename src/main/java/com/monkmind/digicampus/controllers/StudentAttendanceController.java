/*created by:shijina
created on:20/5/2020
*/

package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.StudentAttendance;
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

	@PostMapping("/studentattendanceinsert")
	public String createAttendance(@ModelAttribute StudentAttendance studentattendance, Model model) {
		StudentAttendance studentz = studentattendanceService.save(studentattendance);
		model.addAttribute("studentattendance", studentz);
		return "redirect:/";
	}

	@RequestMapping("/studentattendancedisplay")
	public String displayAttendance(@ModelAttribute StudentAttendance studentattendance, Model model) {
		List<StudentAttendance> attendancelist = studentattendanceService.listAll();
		model.addAttribute("attendancelist", attendancelist);
		studentattendanceService.save(studentattendance);
		return "studentattendancedisplay";
	}

	@RequestMapping("/cha/{id}")
	public String studentattendanceEdit(@PathVariable String id, Model model) {
		System.out.println(id);
		StudentAttendance studentAttendance = studentattendanceService.getId(new String(id));
		model.addAttribute("studentAttendance", studentAttendance);
		return "updatestudentattendance";

	}

	@PostMapping
	@RequestMapping("/updatestudentattendance/{id}")
	public String insertStudentAttendance(@ModelAttribute StudentAttendance studentAttendance, Model model) {
		studentattendanceService.save(studentAttendance);
		return "index";
	}

	@RequestMapping("/vb/{id}")
	public String deleteStudentAttendance(@PathVariable Long id, Model model) {
		studentattendanceService.delete(id);
		return "redirect:/";

	}

}