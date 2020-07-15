package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/addnonteaching")
	public String nonTeaching(Model model) {
		model.addAttribute("nonTeachingStaffCommand",new NonTeachingStaffCommand());
		return "fragments/dc-components/dc-screen-layout/dc-nonteaching/dc-nonteachingstaff-add.html::dc-nonteaching-add";
	}
	@PostMapping(path="/nonteachingstaff")
	public String createnonteaching(@ModelAttribute NonTeachingStaffCommand nonTeachingStaffCommand,Model model) {
		nonteachingservice.saveNonTeachingStaffCommand(nonTeachingStaffCommand);
		return "fragments/dc-components/dc-screen-layout/dc-nonteaching/dc-nonteachingstaff-confirm.html::dc-nonteachingstaff-confirm";
	}

	@GetMapping("/nonteachingdisplay")
	public String nonteachingDisplay(Model model) {
		List<NonTeachingStaff> listteachings=nonteachingservice.listAll();
		model.addAttribute("listteachings",listteachings);
		return "fragments/dc-components/dc-screen-layout/dc-nonteaching/dc-nonteachingstaff-display.html::dc-nonteachingstaff-display";
	}

	@GetMapping("/editnonteachingstaff")
	public String getEditNonTeachingStaffForm(Model model) {
		return "fragments/dc-components/dc-screen-layout/dc-nonteaching/dc-nonteachingstaff-edit::dc-nonteachingstaff-edit";
	}


	@GetMapping("/edit/nonteachingstaff/{staffId}")
	public String nonteachingEdit(@PathVariable String  staffId,Model model) {
		System.out.println(staffId);
		NonTeachingStaff nonteachingstaff = nonteachingservice.getNonTeachingStaffByStaffId(staffId);
		model.addAttribute("nonteachingstaff",nonteachingstaff);
		return "fragments/dc-components/dc-screen-layout/dc-nonteaching/dc-nonteachingstaff-edit-02.html::dc-nonteachingstaff-edit-02";
	}

	@PostMapping(path="/updatenonteachingstaff")
	public String insertNonteaching(@ModelAttribute   NonTeachingStaff nonteachingstaff ,Model model) {
		nonteachingservice.save(nonteachingstaff);
		return "fragments/dc-components/dc-screen-layout/dc-nonteaching/dc-nonteachingstaff-edit-confirm.html::dc-nonteachingstaff-edit-confirm";
	}

	@GetMapping("/delet/{id}")
	public String deletNonteaching(@PathVariable Long id,Model model)
	{
		NonTeachingStaff nonTeachingStaff=nonteachingservice.findById(id);
		nonTeachingStaff.setIsDelete(true);
		nonteachingservice.save(nonTeachingStaff);
		return "redirect:/mydashboard";

	}

	 @GetMapping("/searchnonteaching")
	    public String searchNonteaching(Model model)
	    {
	        model.addAttribute("nonteachings",nonteachingservice.listAll());
	    	return "fragments/dc-components/dc-screen-layout/dc-nonteaching/dc-nonteachingstaff-search.html::dc-nonteaching-search";
	    }

	 @GetMapping()
	    public String nonteachingSearch(@PathVariable String keyword,Model model)
	    {
	        model.addAttribute("nonteachings", nonteachingservice.listAll(keyword));
	        return "fragments/dc-components/dc-screen-layout/dc-nonteaching/dc-nonteachingstaff-list.html::dc-nonteachingstaff-list";
	    }
	   
	 @PostMapping("/nonteachingstaff/profile/{id}")
	    public String nonTeachingStaffProfile(@PathVariable Long id,Model model){
	        model.addAttribute("nonteachingstaff",nonteachingservice.findById(id));
	        return "fragments/dc-components/dc-screen-layout/dc-nonteaching/dc-nonteachingstaff-profile::dc-nonteachingstaff-profile";
	    }
	    

}
