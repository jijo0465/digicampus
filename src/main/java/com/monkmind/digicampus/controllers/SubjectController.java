package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Subject;
import com.monkmind.digicampus.services.SubjectService;


@Controller
public class SubjectController {
	private final SubjectService subjectservice;

	public SubjectController(SubjectService subjectservice) {
		super();
		this.subjectservice = subjectservice;
	}
	
	@RequestMapping("/subject")
	public String subjectinsert(Model model) {
		model.addAttribute("subject",new Subject());
		return "subject";
	}
	@PostMapping("/subjectinsert")
	public String createsubject(@ModelAttribute Subject subject,Model model) {
		subjectservice.save(subject);
		return "subjectdisplay";
	}
	@RequestMapping("/a/{subjectId}")
	public String subjectUpdate(@PathVariable String subjectId,Model model) {
		//ModelAndView mav = new ModelAndView("edit_product");
		System.out.println(subjectId);
	    Subject subject = subjectservice.getById(new Long(subjectId));
	    model.addAttribute("subject",subject);
	     return "updatesubject";
	}
	
	@PostMapping
	@RequestMapping("/updatesubject/{id}")
	public String Insertsubject(@ModelAttribute Subject subject,Model model) {
	    subjectservice.save(subject);
	    return "index";
	}
	
	
	
}
