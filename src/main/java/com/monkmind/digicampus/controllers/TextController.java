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

		
		//return "fragments/dc-components/dc-dashboard-components/dc-breadcrumb/dc-breadcrumb.html::dc-breadcrumb";
		return "fragments/dc-components/dc-screen-layout/dc-student-add.html::dc-student-add";

	}

	@RequestMapping("/gopika")
	public String getForm() {
		return "mydashboard";
	}

	@RequestMapping("/display")


	public String getStud() {
		return "fragments/forms/confirmpage";
	}

	public String getStudt()
	{
		return "fragments/forms/teachertimetable";

	}

	//public String getStud()
	//{
		//return "fragments/display/teachertimetabledisplay";

	//}

	@RequestMapping("/display2")
	public String getTeach() {
		return "fragments/forms/teachertimetabledisplay";
	}
	@RequestMapping("/edit")
	public String getform() {
		return "fragments/edit/studentedit";
}
}
