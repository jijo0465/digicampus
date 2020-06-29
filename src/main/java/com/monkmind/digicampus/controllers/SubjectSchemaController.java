package com.monkmind.digicampus.controllers;

import java.util.List;

import com.monkmind.digicampus.models.Subject;
import com.monkmind.digicampus.models.SubjectSchema;
import com.monkmind.digicampus.models.Teacher;
import com.monkmind.digicampus.services.SubjectSchemaService;
import com.monkmind.digicampus.services.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	 private final SubjectSchemaService subjectSchemaService;
	 private final SubjectService subjectService;
	
	@RequestMapping("/addschemas")
	public String addSchema(Model model)
	{
		List<Grade> gradeCommands = gradeService.listAll();
		Iterable<Subject> subjectList=subjectService.findall();
		SubjectSchema subjectSchema=new SubjectSchema();
		model.addAttribute("subjectSchema",subjectSchema);
		model.addAttribute("subjectList",subjectList);
		model.addAttribute("gradeList", gradeCommands);
		return "fragments/dc-components/dc-screen-layout/dc-subject-schema/dc-schema-add.html::dc-schema-add";
	}

	@PostMapping
	@RequestMapping("/saveschema")
	public String insertSchema(@ModelAttribute  SubjectSchema subjectSchema)
	{
		subjectSchemaService.save(subjectSchema);
        return "fragments/dc-components/dc-screen-layout/dc-student-confirm.html::dc-student-confirm";
	}
	@RequestMapping("edit/schema")
	public String editSchema(Model model)
	{
		List<Grade> gradeList=gradeService.listAll();
		model.addAttribute("gradeList",gradeList);
		return "fragments/dc-components/dc-screen-layout/dc-subject-schema/dc-schema-edit.html";
	}
	
	@RequestMapping("/schemadisplay")
	public String schemaDisplay(Model model) {
		List<SubjectSchema> schemas=subjectSchemaService.findAll();
		model.addAttribute("schemas",schemas);
		return "fragments/dc-components/dc-screen-layout/dc-subject-schema/dc-schema-display.html::dc-schema-display";
	}
}
