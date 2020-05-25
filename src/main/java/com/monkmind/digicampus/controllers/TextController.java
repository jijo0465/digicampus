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
<<<<<<< HEAD
		
		return "fragments/forms/addstud";
				// "::addstud";
=======
		return "fragments/forms/addstud";
>>>>>>> branch 'dev' of https://github.com/jijo0465/digicampus.git
	}
	@RequestMapping("/gopika")
	public String getForm()
	{
		return "mydashboard";
	}
}

        
        
      
         
