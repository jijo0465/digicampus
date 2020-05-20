package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Teacher;
import com.monkmind.digicampus.services.TeacherService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class TeacherController {
	
	private final TeacherService teacherservice;
	
	@RequestMapping("/teacher")
	public String teacherform(Model model) {
		model.addAttribute("teacher",new Teacher());
		return "teacherform";
	}
	@PostMapping("/teacherinsert")
	public String createteacher(@ModelAttribute Teacher teacher,Model model) {
		teacherservice.save(teacher);
		return "index";
	}

}
