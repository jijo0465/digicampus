package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TextController {
	@PostMapping
	
	@RequestMapping("/submit")
	public String getHome()
	{ 

		return "fragments/forms/addstud";

	}
	@RequestMapping("/gopika")
	public String getForm()
	{
		return "fragments/forms/teacher";
	}
}

        
        
      
         
