package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.command.GradeCommand;
import com.monkmind.digicampus.command.RegisterCommand;
import com.monkmind.digicampus.models.Grade;

import com.monkmind.digicampus.services.GradeService;

/*author:shijina
created date:14/5/2020
*/


@Controller
public class GradeController {
	
	private final GradeService gradeService;

	public GradeController(GradeService gradeService) {
		//super();
		this.gradeService = gradeService;
	}
	
	@RequestMapping("/grade_form")
	public String gradeForm(Model model) {
	    model.addAttribute("gradecommand", new GradeCommand());
	    return "grade_form"; 
	    		//"fragments/forms/gradeform::gradeform";
	    		//
	}

	@PostMapping("/gradeinsert")
	public String createGrade(@ModelAttribute GradeCommand gradecommand,Model model) {
		 GradeCommand savedCommand=gradeService.saveGradeCommand(gradecommand);
		 model.addAttribute("gradecommand",gradecommand);
		    return "index";
		}
	
	
	@RequestMapping("/gradedisplay")
	public String displayGrade(@ModelAttribute Grade grade,Model model) {
		List<Grade> listgrades=gradeService.listAll();
		model.addAttribute("listgrades", listgrades);
	    //gradeService.save(grade);
	    return "gradedisplay";
	}
	
	/*author:shijina
	created date:18/5/2020
	*/
	
	@RequestMapping("/et/{id}")
	public String gradeUpdate(@PathVariable String id,Model model) {
		//ModelAndView mav = new ModelAndView("edit_product");
		System.out.println(id);
	    Grade grade =gradeService.getGradeById(new Long(id));
	    model.addAttribute("grade",grade);
	     return "updategrade";
	}
	
	/*@PostMapping
	@RequestMapping("/updategrade/{id}")
	public String InsertGrade(@ModelAttribute Grade grade,Model model) {
	    gradeService.save(grade);
	    return "index";
	}
	*/
	@RequestMapping("/delt/{id}")
	public String deleteGrade(@PathVariable Long id,Model model)
	{
		gradeService.delete(id);
		return "redirect:/";
		
	}
}
