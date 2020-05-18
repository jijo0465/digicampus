package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Parent;
import com.monkmind.digicampus.services.ParentService;

/*author:shijina
created date:15/5/2020
*/


@Controller
public class ParentController {
	
	private final ParentService parentService;

	public ParentController(ParentService parentService) {
		super();
		this.parentService = parentService;
	}

	@RequestMapping("/parentform")
	public String parentForm(Model model) {
	    model.addAttribute("parent", new Parent());
	    return "parent_form";
	}

	@PostMapping
	@RequestMapping("/parentinsert")
	public String createParent(@ModelAttribute Parent parent,Model model) {
	    parentService.save(parent);
	    return "index";
	}
	
}
