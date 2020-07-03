package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

	@PostMapping("/testinsert")
	public String createTest(@ModelAttribute Test test, Model model) {
		Test testz = testService.save(test);
		model.addAttribute("test", testz);
		return "redirect:/";
	}

	@RequestMapping("/testdisplay")
	public String displayTest(@ModelAttribute Test test, Model model) {
		List<Test> testlist = testService.listAll();
		model.addAttribute("testlist", testlist);
		testService.save(test);
		return "testdisplay";
	}

	@RequestMapping("/test/{id}")
	public String gradeUpdate(@PathVariable String id, Model model) {
		// ModelAndView mav = new ModelAndView("edit_product");
		System.out.println(id);
		Test test = testService.getById(new Long(id));
		model.addAttribute("test", test);
		return "updatetest";
	}

	@PostMapping
	@RequestMapping("/updatetest/{id}")
	public String InsertGrade(@ModelAttribute Test test, Model model) {
		testService.save(test);
		return "index";
	}
	@RequestMapping("/fr/{id}")
	public String deleteTest(@PathVariable Long id,Model model)
	{
		testService.delete(id);
		return "redirect:/";
		
	}
	@GetMapping("/new")
	public String newpage(){

		return "new.html";
	}

}
