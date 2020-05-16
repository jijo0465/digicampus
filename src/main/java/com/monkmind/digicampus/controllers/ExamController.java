package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Exam;
import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.services.ExamService;

/*author:shijina
created date:16/5/2020
*/
@Controller
public class ExamController {

	private final ExamService examService;

	public ExamController(ExamService examService) {
		//super();
		this.examService = examService;
	}
	
	@RequestMapping("/exam_form")
	public String gradeForm(Model model) {
	    model.addAttribute("exam", new Exam());
	    return "exam_form";
	}

	@PostMapping
	@RequestMapping("/examinsert")
	public String createGrade(@ModelAttribute Exam exam,Model model) {
	    examService.save(exam);
	    return "index";
	}

	
}
