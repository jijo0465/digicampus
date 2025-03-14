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
	@RequestMapping("/edit/{id}")
	public String studentUpdate(@PathVariable Long id,Model model) {
		//ModelAndView mav = new ModelAndView("edit_product");
		System.out.println(id);
		 List<Grade> gradeCommands = gradeService.listAll();
	   Student savedCommand = studentService.findById(id);
	   model.addAttribute("gradeList", gradeCommands);
	    model.addAttribute("savedCommand",savedCommand);
	     return "fragments/edit/editstudent";
	}
//	
	@PostMapping
	@RequestMapping("/updatestudent/{id}")
	public String InsertStudent(@ModelAttribute  Student savedCommand,Model model) {
		// Student savedCommand=studentService.(command);
		 studentService.save(savedCommand);
		 System.out.println(savedCommand.getDateOfBirth());
	    return "fragments/display/studentdisplay";
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
		return "mydashboard";
		
	}
	@RequestMapping("/studentUpdate/{studentId}")
	public String updatestudent(@PathVariable String studentId,Model model) {
		Student student = studentService.getStudentByStudentId(studentId);
		if(student!=null){
			model.addAttribute("response","exists");
			model.addAttribute("student",student);

		}else{
			model.addAttribute("response","failed");
		}
		return "fragments/forms/editstud::editstud";
	}
	@RequestMapping("/studentupdate")
	public String updatestudent(Model model) {
		List<Grade> gradeCommands = gradeService.listAll();
		model.addAttribute("gradeList", gradeCommands);
		return "fragments/edit/studentedit::studentedit";
	}
	@RequestMapping("/displaystd/{std}")
	public String viewclasswise(@PathVariable  Grade std ,Model model) {
		System.out.println(std);
		List<Student> students=studentService.findByGradeid(std);
		model.addAttribute("students", students);
		return "fragments/display/displaylist::displaylist";
	}

}
