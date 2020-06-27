package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SubjectSchemaController {
	
	
	@RequestMapping("/addschemas")
	public String addSchema(Model model)
	{
		return "fragments/dc-components/dc-screen-layout/dc-schema-add.html::dc-schema-add";
	}

}
