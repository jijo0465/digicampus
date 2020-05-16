package com.monkmind.digicampus.controllers;

import com.monkmind.digicampus.models.Gender;
import com.monkmind.digicampus.models.Parent;
import com.monkmind.digicampus.models.Person;
import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
public class StudentController {
    private final StudentService studentService;

    @ResponseBody
    @RequestMapping(value = "/add_student")
    public String addStudent(){
        Student student = new Student();
        Parent parent = new Parent();
        parent.setName("Thankappan");
        parent.setGender(Gender.MALE);
        student.setName("Ammu");
        student.setGender(Gender.FEMALE);
        student.setParent(parent);
        studentService.addStudent(student);
        return "success";
    }
    
    /*author:shijina
    created date:15/5/2020
    */
    
    
    @RequestMapping("/studentform")
	public String studentForm(Model model) {
	    model.addAttribute("student", new Student());
	    return "student_form";
	}

	@PostMapping
	@RequestMapping("/studentinsert")
	public String createStudent(@ModelAttribute Student student,Model model) {
	    studentService.save(student);
	    return "index";
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
	
	@PostMapping
	@RequestMapping("/updatestudent/{id}")
	public String InsertStudent(@ModelAttribute Student student,Model model) {
	    studentService.save(student);
	    return "index";
	}

}
