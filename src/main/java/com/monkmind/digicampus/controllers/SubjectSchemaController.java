package com.monkmind.digicampus.controllers;

import java.util.List;
import java.util.Optional;

import com.monkmind.digicampus.models.Subject;
import com.monkmind.digicampus.models.SubjectSchema;
import com.monkmind.digicampus.models.Teacher;
import com.monkmind.digicampus.services.SubjectSchemaService;
import com.monkmind.digicampus.services.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/addschemas")
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

	@PostMapping(path="/saveschema")
	public String insertSchema(@ModelAttribute  SubjectSchema subjectSchema)
	{
		subjectSchemaService.save(subjectSchema);
        return "fragments/dc-components/dc-screen-layout/dc-student-confirm.html::dc-student-confirm";
	}
	@GetMapping(path="edit/schema")
	public String schemaClassWise(Model model)
	{
		List<Grade> gradeList=gradeService.listAll();
		model.addAttribute("gradeList",gradeList);
		return "fragments/dc-components/dc-screen-layout/dc-subject-schema/dc-schema-classwise.html";
	}
	@GetMapping(path = "schema/classwise/{grade}")
	public String editSchemaclasswise(@PathVariable Grade grade,Model model){
		List<SubjectSchema> subjectSchemas=subjectSchemaService.findByGrade(grade);
		model.addAttribute("schemaList",subjectSchemas);
		return "fragments/dc-components/dc-screen-layout/dc-subject-schema/dc-schema-display.html::dc-schema-classwise";
	}
	@PostMapping(path = "schema/edit/{schemaId}")
	public String editSchema(@PathVariable Long schemaId, Model model){
		SubjectSchema subjectSchema=subjectSchemaService.findById(schemaId);
		Iterable<Subject> subjectList=subjectService.findall();
		List<Grade> gradeList=gradeService.listAll();
		model.addAttribute("subjectList",subjectList);
		model.addAttribute("gradeList",gradeList);
		model.addAttribute("subjectSchema",subjectSchema);
		return "fragments/dc-components/dc-screen-layout/dc-subject-schema/dc-schema-edit.html::dc-schema-edit";
	}
	@PostMapping(path="/updateschema")
	public String updateSchema(@ModelAttribute SubjectSchema subjectSchema){
		subjectSchemaService.save(subjectSchema);
		return "/";
	}
	
	@GetMapping("/schemadisplay")
	public String schemaDisplay(Model model) {
		List<SubjectSchema> schemas=subjectSchemaService.findAll();
		model.addAttribute("schemaList",schemas);
		return "fragments/dc-components/dc-screen-layout/dc-subject-schema/dc-schema-display.html::dc-schema-display";
	}
	
	

}
