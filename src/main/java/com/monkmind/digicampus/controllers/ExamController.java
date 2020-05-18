package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Exam;
import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.Student;
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
	    return "examformdisplay";
	}
	@RequestMapping("/ei/{id}")
	public String studentUpdate(@PathVariable String id,Model model) {
		//ModelAndView mav = new ModelAndView("edit_product");
		System.out.println(id);
	    Exam exam = examService.getExamById(new Long(id));
	    model.addAttribute("exam",exam);
	     return "updateexam";
	}
	
	@PostMapping
	@RequestMapping("/updateexam/{id}")
	public String InsertStudent(@ModelAttribute Exam exam,Model model) {
	    examService.save(exam);
	    return "index";
	}


	
}
