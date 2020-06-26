
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
	public String createteacher(@ModelAttribute TeacherRegisterCommand teachercommand) {
		teacherservice.saveTeacherRegisterCommand(teachercommand);
		return "fragments/dc-components/dc-screen-layout/dc-student-confirm.html::dc-student-confirm";
	}
	
	

	@RequestMapping("/teacherdisplay")
	public String teacherDisplay(Model model) {
		List<Teacher> teachers=teacherservice.findAll();
		model.addAttribute("teachers",teachers);
		return "fragments/dc-components/dc-screen-layout/dc-teacher-display.html::dc-teacher-display";
	}
	@RequestMapping("/edit/teacher")
	public String getEditStudentForm(Model model) {
		return "fragments/dc-components/dc-screen-layout/dc-teacher-edit::dc-teacher-edit";
	}
	
	@RequestMapping("/edit/teacher/{teacherId}")
	public String teacherUpdate(@PathVariable String teacherId,Model model) {
		System.out.println(teacherId);
		Teacher teacher = teacherservice.getTeacherByTeacherId(teacherId);
		model.addAttribute("teacher",teacher);
		return "fragments/dc-components/dc-screen-layout/dc-teacher-edit-02.html::dc-teacher-edit-02";
	}
	
	@PostMapping
	@RequestMapping("updateteacher")
	public String Insertteacher(@ModelAttribute Teacher teacher,Model model) {
	    teacherservice.save(teacher);
	    return "fragments/dc-components/dc-screen-layout/dc-student-confirm.html::dc-student-confirm";
	}
	
	@RequestMapping("/deletins/{id}")
	public String deleteTeacher(@PathVariable Long id,Model model)
	{
		Teacher teacher=teacherservice.findById(id);
		teacher.setIsDelete(true);
		teacherservice.save(teacher);
		return "redirect:/mydashboard";
		
	}
	
	 @RequestMapping("/searchteacher")
	    public String searchTeacher(Model model)
	    {
	    	return "fragments/dc-components/dc-screen-layout/dc-teacher-search.html::dc-teacher-search";
	    }
}
