package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.NonTeachingStaff;
import com.monkmind.digicampus.models.StudentTimeTable;
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
		return "nonteachingdisplay";
	}
	
	@RequestMapping("/i/{staffid}")
	public String nonteachingEdit(@PathVariable String staffid,Model model) {
		System.out.println(staffid);
	    NonTeachingStaff nonTeachingstaff = nonteachingservice.getById(new Long(staffid));
	    model.addAttribute("nonTeachingstaff",nonTeachingstaff);
	     return "updatenonteachingstaff";
	}
	
	@PostMapping
	@RequestMapping("/updatenonteaching/{staffid}")
	public String insertNonteaching(@ModelAttribute   NonTeachingStaff nonTeachingstaff ,Model model) {
		nonteachingservice.save(nonTeachingstaff);
	    return "index";
	}


}
