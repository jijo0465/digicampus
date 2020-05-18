package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Parent;
import com.monkmind.digicampus.services.ParentService;



import lombok.AllArgsConstructor;

/*author:shijina
created date:15/5/2020
*/


@AllArgsConstructor
@Controller
public class ParentController {
	
	private final ParentService parentService;

	@RequestMapping("/parentform")
	public String parentForm(Model model) {
	    model.addAttribute("parent", new Parent());
	    return "parent_form";
	}

	@PostMapping
	@RequestMapping("/parentinsert")
	public String createParent(@ModelAttribute Parent parent,Model model) {
	    parentService.save(parent);
	    return "parentdisplay";
	}
	
	/*author:shijina
	created date:18/5/2020
	*/
	
	@RequestMapping("/edt/{parentId}")
	public String parentUpdate(@PathVariable String parentId,Model model) {
		//ModelAndView mav = new ModelAndView("edit_product");
		System.out.println(parentId);
	    Parent parents = parentService.get(new Long(parentId));
	    model.addAttribute("parent",parents);
	     return "updateparent";
	}
	
	@PostMapping
	@RequestMapping("/updateparent/{id}")
	public String InsertParent(@ModelAttribute Parent parent,Model model) {
	    parentService.save(parent);
	    return "index";
	}
	

}
