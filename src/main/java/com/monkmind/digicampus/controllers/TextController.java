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

		
		//return "fragments/dc-components/dc-form-component/dc-form-dropdown/dc-form-dropdown::dc-form-dropdown";
		return "fragments/dc-components/dc-alert/dc-sucess-alert::dc-sucess-alert";

	}

	@RequestMapping("/gopika")
	public String getForm() {
		return "fragments/dc-components/dc-screen-layout/dc-teacher-display::dc-teacher-display";
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
