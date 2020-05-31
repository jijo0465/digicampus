
package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Student;
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
		return "fragments/forms/teacher::teacher";
	}
	@PostMapping("/teacherinsert")
	public String createteacher(@ModelAttribute Teacher teacher,Model model) {
		teacherservice.save(teacher);
		return "index";
	}
	
	@RequestMapping("teachername")
	public String showByName(@PathVariable String name,Model model)
	{
		model.addAttribute("teacher",teacherservice.findByName(String.valueOf(name)));
		return "teachername";
	}
	

	@RequestMapping("/teacherdisplay")
	public String teacherDisplay(Model model) {
		List<Teacher> teachers=teacherservice.findAll();
		model.addAttribute("teachers",teachers);
		return "teacherdisplay";
	}
	
	@RequestMapping("/t/{teacherId}")
	public String teacherUpdate(@PathVariable String teacherId,Model model) {
		//ModelAndView mav = new ModelAndView("edit_product");
		System.out.println(teacherId);
	    Teacher teacher = teacherservice.getById(new Long(teacherId));
	    model.addAttribute("teacher",teacher);
	     return "updateteacher";
	}
	
	@PostMapping
	@RequestMapping("/updateteacher/{id}")
	public String Insertteacher(@ModelAttribute Teacher teacher,Model model) {
	    teacherservice.save(teacher);
	    return "index";
	}
	
	@RequestMapping("/deletins/{id}")
	public String deleteTeacher(@PathVariable Long id,Model model)
	{
		teacherservice.delete(id);
		return "redirect:/";
		
	}
}
