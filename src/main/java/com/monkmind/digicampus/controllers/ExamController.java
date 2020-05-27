package com.monkmind.digicampus.controllers;

import java.util.List;

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
		// super();
		this.examService = examService;
	}

	@RequestMapping("/exam_form")
	public String gradeForm(Model model) {
		model.addAttribute("exam", new Exam());
		return "exam_form";
	}
	//haritha
	//date:26/05/2020

	@PostMapping("/examinsert")
	public String createGrade(@ModelAttribute Exam exam, Model model) {
		Exam examz = examService.save(exam);
		model.addAttribute("exam", examz);
		return "redirect:/";
	}


	@RequestMapping("/examdisplay")
	public String displayExam(@ModelAttribute Exam exam, Model model) {
		// Exam exams=examService.getById(exam).add(exams);
		List<Exam> listexams = examService.listAll();
		model.addAttribute("listexams", listexams);
		examService.save(exam);
		return "examformdisplay";
}

	
	

	@RequestMapping("/ei/{id}")
	public String updateExam(@PathVariable String id, Model model) {
		// ModelAndView mav = new ModelAndView("edit_product");
		System.out.println(id);
		Exam exam = examService.getExamById(new Long(id));
		model.addAttribute("exam", exam);
		return "updateexam";
	}

	@PostMapping
	@RequestMapping("/updateexam/{id}")
	public String InsertStudent(@ModelAttribute Exam exam, Model model) {
		examService.save(exam);
		return "index";
	}
	// haritha
	// date:25/05/2020

	@RequestMapping("/del/{id}")
	public String deleteExam(@PathVariable Long id, Model model) {
		examService.delete(id);
		return "redirect:/";

	}
	
	

}
