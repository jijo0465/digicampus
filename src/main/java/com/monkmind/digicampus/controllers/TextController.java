package com.monkmind.digicampus.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TextController {
	@PostMapping

	@RequestMapping("/submit")

	public String getHome()
	{ 


		return "fragments/forms/addstud";

	}

	@RequestMapping("/gopika")
	public String getForm() {
		return "mydashboard";
	}

	@RequestMapping("/display")


	public String getStud() {
		return "fragments/display/studentdisplay";
	}

	public String getStudt()
	{
		return "fragments/forms/teachertimetabledisplay";

	}

	//public String getStud()
	//{
		//return "fragments/display/teachertimetabledisplay";

	//}

	@RequestMapping("/display2")
	public String getTeach() {
		return "fragments/forms/teachertimetable";
	}
}
