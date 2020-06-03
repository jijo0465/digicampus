package com.monkmind.digicampus.controllers;


import com.monkmind.digicampus.command.RegisterCommand;
import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.models.User;
import com.monkmind.digicampus.services.GradeService;
import com.monkmind.digicampus.services.StudentService;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@Controller
public class StudentController {
    private final StudentService studentService;
    private final GradeService gradeService;
    //@PostMapping
  //  @RequestMapping("/add_student")
   // public String addStudent(){
   //     return "fragments/forms/addstud";
   // }
    
    /*author:shijina
    created date:15/5/2020
    */

    @RequestMapping("/add_student")
	public String studentForm(Model model) {
        RegisterCommand registerCommand = new RegisterCommand();
        List<Grade> gradeCommands = gradeService.listAll();
	    model.addAttribute("command", registerCommand);
	    model.addAttribute("gradeList", gradeCommands);
	    return "fragments/forms/addstud::addstud";
	}

	@PostMapping
	@RequestMapping("/addstudent")
	public String Save(@ModelAttribute RegisterCommand command, Model model) {
		System.out.println(command.getGradeid().getId());
		System.out.println(command.getStudentId());
		long parentid = (long) Math.floor(Math.random() * 9000000L) + 100000L;
		
		System.out.println(parentid);
		command.getParentid().setParentId(Long.toString(parentid));
		System.out.println(command.getParentid().getParentId());
	   RegisterCommand savedCommand=studentService.saveRegisterCommand(command);
	    return "fragments/forms/confirmpage::confirmpage";
	}
	
	

	  @RequestMapping("/studentdisplay")
		public String studentdisplay(Model model) {
		  List<Student> liststudents=studentService.listAll();
		  List<Grade> gradeCommands = gradeService.listAll();
		  model.addAttribute("gradeList", gradeCommands);
		   model.addAttribute("liststudents",liststudents);
		    return "fragments/display/studentdisplay::studentdisplay";

		}
	@PostMapping("/displaycls")
	public String displaycls(@ModelAttribute Grade std) {
		System.out.println(std.getId());
		
		return "mydashboard";
	}

	/*author:shijina
    created date:16/5/2020
    */
	
//
//	@RequestMapping("/edit/{id}")
//	public String studentUpdate(@PathVariable String id,Model model) {
//		//ModelAndView mav = new ModelAndView("edit_product");
//		System.out.println(id);
//	   RegisterCommand savedCommand = studentService.findCommandById(Long.valueOf(id));
//	    model.addAttribute("savedCommand",savedCommand);
//	     return "fragments/forms/updatestudent";
//	}
//	
	@PostMapping
	@RequestMapping("/updatestudent/{id}")
	public String InsertStudent(@ModelAttribute  RegisterCommand  command,Model model) {
		 RegisterCommand savedCommand=studentService.saveRegisterCommand(command);
		// studentService.save(student);
	    return "index";
	}

	@ResponseBody
	@RequestMapping("/validateStudentId/{studentId}")
	public String InsertStudent(@PathVariable  String studentId ,Model model) {
		System.out.println(studentId);
		Student s = studentService.getStudentByStudentId(studentId);
		if(s!=null){
			return "exists";
		}else{
			return "notExists";
		}
	}

	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id,Model model)
	{
		studentService.delete(id);
		return "redirect:/";
		
	}
	@RequestMapping("/studentupdate")
	public String updatestudent() {
		return "fragments/edit/studentedit::studentedit";
	}

}
