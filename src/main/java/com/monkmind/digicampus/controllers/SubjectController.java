package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Period;
import com.monkmind.digicampus.models.StudentTimeTable;
import com.monkmind.digicampus.models.Subject;
import com.monkmind.digicampus.services.PeriodService;
import com.monkmind.digicampus.services.SubjectService;


@Controller
public class SubjectController {
	private final SubjectService subjectservice;
	private final PeriodService periodservice;

	public SubjectController(SubjectService subjectservice,PeriodService periodservice) {
		super();
		this.subjectservice = subjectservice;
		this.periodservice = periodservice;
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
	
	@RequestMapping("/subjectperiod")
	public String SubjectPeriod() {
		Long id=(long) 2;
		Period period=periodservice.getByPeriodId(id);
		List<Subject> subjects=subjectservice.getByPeriodId(period);
		for (Subject subject : subjects) {
			System.out.println(subject.getName());
		}
		return "dashboard";
	}
	
}
