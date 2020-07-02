
package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.command.TeacherRegisterCommand;
import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.models.Teacher;
import com.monkmind.digicampus.services.TeacherService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class TeacherController {
	
	private final TeacherService teacherservice;
	
	@GetMapping("/teacher")
	public String teacherform(Model model) {
		model.addAttribute("teachercommand",new TeacherRegisterCommand());
		return "fragments/dc-components/dc-screen-layout/dc-teacher/dc-teacher-add.html::dc-teacher-add";
	}
	@PostMapping(path="/addteacher")
	public String createteacher(@ModelAttribute TeacherRegisterCommand teachercommand) {
		teacherservice.saveTeacherRegisterCommand(teachercommand);
		return "fragments/dc-components/dc-screen-layout/dc-teacher/dc-teacher-confirm.html::dc-teacher-confirm";
	}
	
	@GetMapping("/teacherdisplay")
	public String teacherDisplay(Model model) {
		List<Teacher> teachers=teacherservice.findAll();
		model.addAttribute("teachers",teachers);
		return "fragments/dc-components/dc-screen-layout/dc-teacher/dc-teacher-display.html::dc-teacher-display";
	}
	@GetMapping("/edit/teacher")
	public String getEditStudentForm(Model model) {
		return "fragments/dc-components/dc-screen-layout/dc-teacher/dc-teacher-edit::dc-teacher-edit";
	}
	
	@GetMapping("/edit/teacher/{teacherId}")
	public String teacherUpdate(@PathVariable String teacherId,Model model) {
		System.out.println(teacherId);
		Teacher teacher = teacherservice.getTeacherByTeacherId(teacherId);
		model.addAttribute("teacher",teacher);
		return "fragments/dc-components/dc-screen-layout/dc-teacher/dc-teacher-edit-02.html::dc-teacher-edit-02";
	}
	
	@PostMapping(path="/updateteacher")
	public String Insertteacher(@ModelAttribute Teacher teacher,Model model) {
	    teacherservice.save(teacher);
	    return "fragments/dc-components/dc-screen-layout/dc-student-confirm.html::dc-student-confirm";
	}
	
	@GetMapping("/deleted/{id}")
	public String deleteTeacher(@PathVariable Long id,Model model)
	{
		Teacher teacher=teacherservice.findById(id);
		teacher.setIsDelete(true);
		teacherservice.save(teacher);
		return "redirect:/mydashboard";
	}
	@GetMapping("/searchteacher")
	public String searchTeacher(Model model)
	{
			List<Teacher> teacher=teacherservice.listAll();
	        model.addAttribute("teachers",teacher);
	    	return "fragments/dc-components/dc-screen-layout/dc-teacher/dc-teacher-search.html::dc-teacher-search";
	 }
	 @GetMapping("/teacher/search/{keyword}")
	    public String teacherSearch(@PathVariable String keyword,Model model)
	    {
	        List<Teacher> teachers = teacherservice.listAll(keyword);
	        model.addAttribute("teachers", teachers);
	        //model.addAttribute("keyword", keyword);
	        return "fragments/dc-components/dc-screen-layout/dc-teacher/dc-teacher-list.html::dc-teacher-list";
	    }
}
