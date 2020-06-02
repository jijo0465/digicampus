package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.NonTeachingStaff;
import com.monkmind.digicampus.services.NonTeachinService;

@Controller
public class NonTeachingController {
	private final NonTeachinService nonteachingservice;

	public NonTeachingController(NonTeachinService nonteachingservice) {
		//super();
		this.nonteachingservice = nonteachingservice;
	}
	@RequestMapping("/nonteaching")
	public String nonTeaching(Model model) {
		model.addAttribute("nonteachingstaff",new NonTeachingStaff());
		return "nonteaching_form";
	}
	@PostMapping("/nonteachingstaff")
	public String createnonteaching(@ModelAttribute NonTeachingStaff nonteachingstaff,Model model) {
		NonTeachingStaff staff=nonteachingservice.save(nonteachingstaff);
		model.addAttribute("nonteachingstaff",staff);
		return "redirect:/";
	}
	
	@RequestMapping("/nonteachingdisplay")
	public String nonteachingDisplay(Model model) {
		List<NonTeachingStaff> listteachings=nonteachingservice.listAll();
		model.addAttribute("listteachings",listteachings);
		return "nonteachingdisplay";
	}
	
	@RequestMapping("/change/{id}")
	public String nonteachingEdit(@PathVariable String id,Model model) {
		System.out.println(id);
	    NonTeachingStaff nonTeachingstaff = nonteachingservice.getById(new Long(id));
	    model.addAttribute("nonTeachingstaff",nonTeachingstaff);
	     return "updatenonteachingstaff";
	}
	
	@PostMapping
	@RequestMapping("/updatenonteaching/{id}")
	public String insertNonteaching(@ModelAttribute   NonTeachingStaff nonTeachingstaff ,Model model) {
		nonteachingservice.save(nonTeachingstaff);
	    return "index";
	}
	
	@RequestMapping("/dele/{id}")
	public String deleteNonteaching(@PathVariable Long id,Model model)
	{
		nonteachingservice.delete(id);
		return "redirect:/";
		
	}


}
