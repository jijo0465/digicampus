package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.services.GradeService;
import com.monkmind.digicampus.services.StudentService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class SubjectSchemaController {
	
	 private final GradeService gradeService;
	 private final StudentService studentService;
	
	@RequestMapping("/addschemas")
	public String addSchema(Model model)
	{
		return "fragments/dc-components/dc-screen-layout/dc-schema-add.html::dc-schema-add";
	}

	
	@RequestMapping("/insertschema")
	public String insertSchema(@PathVariable Grade std , Model model)
	{
		System.out.println(std);
       // List<Student> students = studentService.findByGradeid(std);
		List<Grade> gradeCommands = gradeService.listAll();
        model.addAttribute("gradeList", gradeCommands);
      //  model.addAttribute("liststudents", students);
        return "/";
	}
}
