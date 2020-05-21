package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Period;
import com.monkmind.digicampus.services.PeriodService;

//Anand A B 18/05/2020

@Controller
public class PeriodController {
	private final PeriodService periodService;

	public PeriodController(PeriodService periodService) {
		super();
		this.periodService = periodService;
	}
	@RequestMapping("/periodform")
	public String periodinsert(Model model) {
		model.addAttribute("period",new Period());
		return "period_form";
	}
	@PostMapping("/periodinsert")
	public String createperiod(@ModelAttribute Period period,Model model) {
		periodService.save(period);
		return "perioddisplay";
	}
}
