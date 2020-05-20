package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.Test;
import com.monkmind.digicampus.services.TestService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class TestController {
	private final TestService testService;
	
	@RequestMapping("/testform")
	public String testForm(Model model) {
	    model.addAttribute("test", new Test());
	    return "test_form";
	}
	@PostMapping
	@RequestMapping("/testinsert")
	public String createTest(@ModelAttribute Test test,Model model) {
	    testService.save(test);
	    return "index";
	}

}
