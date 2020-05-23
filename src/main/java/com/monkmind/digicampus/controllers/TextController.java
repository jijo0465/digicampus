package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TextController {
	@RequestMapping("/submit")
	public String getHome()
	{ 
		return "fragments/forms/addstud";
	}
	
}
        
        
      
         
