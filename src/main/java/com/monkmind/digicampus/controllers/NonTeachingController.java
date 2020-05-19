package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.NonTeachingStaff;
import com.monkmind.digicampus.services.NonTeachinService;

@Controller
public class NonTeachingController {
	private final NonTeachinService nonteachingservice;

	public NonTeachingController(NonTeachinService nonteachingservice) {
		super();
		this.nonteachingservice = nonteachingservice;
	}
	@RequestMapping("/nonteaching")
	public String nonTeaching(Model model) {
		model.addAttribute("nonteaching",new NonTeachingStaff());
		return "nonteaching_form";
	}
	@PostMapping("/nonteachingstaff")
	public String createnonteaching(@ModelAttribute NonTeachingStaff nonteachingstaff,Model model) {
		nonteachingservice.save(nonteachingstaff);
		return "index";
	}

}
