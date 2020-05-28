package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.command.GradeCommand;
import com.monkmind.digicampus.command.SchoolBusCommand;
import com.monkmind.digicampus.models.SchoolBus;

import com.monkmind.digicampus.services.SchoolbusService;


/*author:shijina
created date:14/5/2020
*/


@Controller
public class SchoolbusController {
	
	private final SchoolbusService schoolbusService;

	public SchoolbusController(SchoolbusService schoolbusService) {
		//super();
		this.schoolbusService = schoolbusService;
	}
	
	@RequestMapping("/schoolbus")
	public String schoolBus(Model model) {
		model.addAttribute("schoolBusCommand",new SchoolBusCommand());
		return "schoolbus";
	}

	@PostMapping("/schoolbusinsert")
	public String createSchoolbus(@ModelAttribute SchoolBusCommand schoolBusCommand,Model model) {
     SchoolBusCommand savedCommand=schoolbusService.saveSchoolBusCommand(schoolBusCommand);
	 model.addAttribute("schoolBusCommand",schoolBusCommand);
	    return "redirect:/";
	}
	
	@RequestMapping("/schoolbusdisplay")
	public String SchoolbusDisplay(@ModelAttribute SchoolBus schoolbus,Model model) {
		List<SchoolBus> listschoolbus=schoolbusService.listAll();
		model.addAttribute("listschoolbus",listschoolbus);
	    //schoolbusService.save(schoolbus);
	    return "schoolbusDisplay";
	}
	
	/*author:shijina
	created date:18/5/2020
	*/

	
	@RequestMapping("/edi/{busNumber}")
	public String schoolBusEdit(@PathVariable String busNumber,Model model) {
		System.out.println(busNumber);
	    SchoolBus schoolBuss = schoolbusService.getBusNumber(new Long(busNumber));
	    model.addAttribute("schoolBus",schoolBuss);
	     return "updateschoolbus";
	}
	
	/*@PostMapping
	@RequestMapping("/updateschoolBus/{busNumber}")
	public String InsertSchoolBus(@ModelAttribute SchoolBus schoolBus,Model model) {
	    schoolbusService.save(schoolBus);
	    return "index";
	}
	*/
	//haritha
	//date:25/05/2020
	@RequestMapping("/dlt/{busNumber}")
	public String deleteSchoolBus(@PathVariable Long busNumber,Model model)
	{
		//schoolbusService.delete(busNumber);
		return "redirect:/";
		
	}
}
