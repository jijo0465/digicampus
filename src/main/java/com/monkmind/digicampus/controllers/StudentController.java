package com.monkmind.digicampus.controllers;

import com.monkmind.digicampus.command.RegisterCommand;
import com.monkmind.digicampus.models.Gender;

import com.monkmind.digicampus.models.Parent;
import com.monkmind.digicampus.models.Person;
import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@AllArgsConstructor
@Controller
public class StudentController {
    private final StudentService studentService;

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
	    model.addAttribute("command", new RegisterCommand());
	    return "fragments/forms/addstud::addstud";
	}

	@PostMapping
	@RequestMapping("/addstudent")
	public String Save(@ModelAttribute RegisterCommand command, Model model) {
		System.out.println(command.getGradeid().getId());
	   RegisterCommand savedCommand=studentService.saveRegisterCommand(command);
	    return "mydashboard";
	}
	
	

	  @RequestMapping("/studentdisplay")
		public String studentdisplay(Model model) {
		  List<Student> liststudents=studentService.listAll();
		    model.addAttribute("liststudents",liststudents);
		    return "fragments/display/studentdisplay::studentdisplay";

		}
	

	/*author:shijina
    created date:16/5/2020
    */
	

	@RequestMapping("/edit/{studentId}")
	public String studentUpdate(@PathVariable String studentId,Model model) {
		//ModelAndView mav = new ModelAndView("edit_product");
		System.out.println(studentId);
	    Student students = studentService.get(new Long(studentId));
	    model.addAttribute("student",students);
	     return "updatestudent";
	}
	
	/*@PostMapping
	@RequestMapping("/updatestudent/{id}")
	public String InsertStudent(@ModelAttribute Student student,Model model) {
	    studentService.save(student);
	    return "index";
	}
	*/
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id,Model model)
	{
		studentService.delete(id);
		return "redirect:/";
		
	}

}
