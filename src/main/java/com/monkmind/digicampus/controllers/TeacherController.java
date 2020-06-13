
package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.command.TeacherRegisterCommand;
import com.monkmind.digicampus.models.Teacher;
import com.monkmind.digicampus.services.TeacherService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class TeacherController {
	
	private final TeacherService teacherservice;
	
	@RequestMapping("/teacher")
	public String teacherform(Model model) {
		model.addAttribute("teachercommand",new TeacherRegisterCommand());
		return "fragments/dc-components/dc-screen-layout/dc-teacher-add.html::dc-teacher-add";
	}
	@PostMapping
	@RequestMapping("/addteacher")
	public String createteacher(@ModelAttribute TeacherRegisterCommand teachercommand,Model model) {
		TeacherRegisterCommand savedCommand=teacherservice.saveTeacherRegisterCommand(teachercommand);
		//teacherservice.save(savedcommand);
		return "fragments/forms/confirmpage::confirmpage";
	}
	
	

	@RequestMapping("/teacherdisplay")
	public String teacherDisplay(Model model) {
		List<Teacher> teachers=teacherservice.findAll();
		model.addAttribute("teachers",teachers);
		return "fragments/dc-components/dc-screen-layout/dc-teacher-display.html::dc-teacher-display";
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
