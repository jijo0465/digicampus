package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.command.NonTeachingStaffCommand;
import com.monkmind.digicampus.models.NonTeachingStaff;
import com.monkmind.digicampus.services.NonTeachinService;

@Controller
public class NonTeachingController {
	private final NonTeachinService nonteachingservice;

	public NonTeachingController(NonTeachinService nonteachingservice) {
		//super();
		this.nonteachingservice = nonteachingservice;
	}
	@RequestMapping("/addnonteaching")
	public String nonTeaching(Model model) {
		model.addAttribute("nonTeachingStaffCommand",new NonTeachingStaffCommand());
		return "fragments/dc-components/dc-screen-layout/dc-nonteaching/dc-nonteachingstaff-add.html::dc-nonteaching-add";
	}
	@PostMapping("/nonteachingstaff")
	public String createnonteaching(@ModelAttribute NonTeachingStaffCommand nonTeachingStaffCommand,Model model) {
		nonteachingservice.saveNonTeachingStaffCommand(nonTeachingStaffCommand);
		return "fragments/dc-components/dc-screen-layout/dc-student-confirm.html::dc-student-confirm";
	}

	@RequestMapping("/nonteachingdisplay")
	public String nonteachingDisplay(Model model) {
		List<NonTeachingStaff> listteachings=nonteachingservice.listAll();
		model.addAttribute("listteachings",listteachings);
		return "fragments/dc-components/dc-screen-layout/dc-nonteaching/dc-nonteachingstaff-display.html::dc-nonteachingstaff-display";
	}

	@RequestMapping("/editnonteachingstaff")
	public String getEditNonTeachingStaffForm(Model model) {
		return "fragments/dc-components/dc-screen-layout/dc-nonteaching/dc-nonteachingstaff-edit::dc-nonteachingstaff-edit";
	}


	@RequestMapping("/edit/nonteachingstaff/{staffId}")
	public String nonteachingEdit(@PathVariable String  staffId,Model model) {
		System.out.println(staffId);
		NonTeachingStaff nonteachingstaff = nonteachingservice.getNonTeachingStaffByStaffId(staffId);
		model.addAttribute("nonteachingstaff",nonteachingstaff);
		return "fragments/dc-components/dc-screen-layout/dc-nonteaching/dc-nonteachingstaff-edit-02.html::dc-nonteachingstaff-edit-02";
	}

	@PostMapping
	@RequestMapping("/updatenonteachingstaff")
	public String insertNonteaching(@ModelAttribute   NonTeachingStaff nonteachingstaff ,Model model) {
		nonteachingservice.save(nonteachingstaff);
		return "fragments/dc-components/dc-screen-layout/dc-student-confirm.html::dc-student-confirm";
	}

	@RequestMapping("/dele/{id}")
	public String deleteNonteaching(@PathVariable Long id,Model model)
	{
		nonteachingservice.delete(id);
		return "redirect:/";

	}


}
