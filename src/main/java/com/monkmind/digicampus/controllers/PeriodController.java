package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.Period;
import com.monkmind.digicampus.models.StudentTimeTable;
import com.monkmind.digicampus.services.PeriodService;
import com.monkmind.digicampus.services.StudentService;
import com.monkmind.digicampus.services.StudentTimetableService;

//Anand A B 18/05/2020

@Controller
public class PeriodController {
	private final PeriodService periodService;
	private final StudentTimetableService studentTimetableService;

	
	public PeriodController(PeriodService periodService, StudentTimetableService studentTimetableService) {
		super();
		this.periodService = periodService;
		this.studentTimetableService = studentTimetableService;
	}

	@RequestMapping("/periodform")
	public String periodinsert(Model model) {
		model.addAttribute("period",new Period());
		return "period_form";
	}
	
	@PostMapping("/periodinsert")
	public String createperiod(@ModelAttribute Period period,Model model) {
		Period periodz	=periodService.save(period);
		model.addAttribute("Period", periodz);
		return "redirect:/";
	}
	
	@RequestMapping("/perioddisplay")
	public String periodDisplay(@PathVariable Period period,Model model) {
		List<Period> periodlist=periodService.listAll();
		 model.addAttribute("periodlist",periodlist);
		 periodService.save(period);
	     return "perioddisplay";
	}
	
	
	@RequestMapping("/pedit/{id}")
	public String periodUpdate(@PathVariable String id,Model model) {
		//ModelAndView mav = new ModelAndView("edit_product");
		System.out.println(id);
	    Period period = periodService.getByPeriodId(new Long(id));
	    model.addAttribute("period",period);
	     return "updateperiod";
	}
	
	@PostMapping
	@RequestMapping("/updateperiod/{id}")
	public String InsertPeriod(@ModelAttribute Period period,Model model) {
	    periodService.save(period);
	    return "index";
	}
	@RequestMapping("/we/{id}")
	public String deletePeriod(@PathVariable Long id,Model model)
	{
		periodService.delete(id);
		return "redirect:/";
		
	}
	@RequestMapping("/period")
	public String period(){
		Long id=(long) 2;
		StudentTimeTable studentTimeTable=studentTimetableService.getById(id);
		List<Period> periods=periodService.getByStudentTimeTable(studentTimeTable);
		for (Period period : periods) {
			System.out.println(period.getId());
		}
		
		return "/dashboard";		
	}
	
}
