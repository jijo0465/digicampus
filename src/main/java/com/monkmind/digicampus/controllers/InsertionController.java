package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.Parent;
import com.monkmind.digicampus.models.SchoolBus;
import com.monkmind.digicampus.services.GradeService;
import com.monkmind.digicampus.services.ParentService;
import com.monkmind.digicampus.services.SchoolbusService;

//import com.example.demo.Model.Category;

/*author:shijina
created date:14/5/2020
*/

@Controller
public class InsertionController {
	private final GradeService gradeService;
	private final SchoolbusService schoolbusService;
	private final ParentService parentService;
	
	
	public InsertionController(GradeService gradeService,SchoolbusService schoolbusService,ParentService parentService) {
		//super();
		this.gradeService = gradeService;
		this.schoolbusService= schoolbusService;
		this.parentService= parentService;
	}

	@RequestMapping("/grade_form")
	public String gradeForm(Model model) {
	    model.addAttribute("grade", new Grade());
	    return "grade_form";
	}

	@PostMapping
	@RequestMapping("/gradeinsert")
	public String createGrade(@ModelAttribute Grade grade,Model model) {
	    gradeService.save(grade);
	    return "index";
	}
	
	@RequestMapping("/schoolbus")
	public String busForm(Model model) {
	    model.addAttribute("schoolbus", new SchoolBus());
	    return "schoolbus";
	}

	@PostMapping
	@RequestMapping("/schoolbusinsert")
	public String createSchoolbus(@ModelAttribute SchoolBus schoolbus,Model model) {
	    schoolbusService.save(schoolbus);
	    return "index";
	}
	
	/*author:shijina
	created date:15/5/2020
	*/
	
	@RequestMapping("/parentform")
	public String parentForm(Model model) {
	    model.addAttribute("parent", new Parent());
	    return "parent_form";
	}

	@PostMapping
	@RequestMapping("/parentinsert")
	public String createStudent(@ModelAttribute Parent parent,Model model) {
	    parentService.save(parent);
	    return "index";
	}

}
