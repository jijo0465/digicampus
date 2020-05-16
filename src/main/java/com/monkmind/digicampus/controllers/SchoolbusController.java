package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.SchoolBus;
import com.monkmind.digicampus.services.SchoolbusService;


/*author:shijina
created date:14/5/2020
*/


@Controller
public class SchoolbusController {
	
	private final SchoolbusService schoolbusService;

	public SchoolbusController(SchoolbusService schoolbusService) {
		super();
		this.schoolbusService = schoolbusService;
	}
	
	@RequestMapping("/schoolbus")
	public String busForm(Model model) {
	    model.addAttribute("schoolbus", new SchoolBus());
	    return "schoolbus";
	}

	@PostMapping
	@RequestMapping("/schoolbusinsert")
	public String createSchoolbus(@ModelAttribute SchoolBus schoolbus,Model model) {
	    schoolbusService.save(schoolbus);
	    return "index";
	}

}
