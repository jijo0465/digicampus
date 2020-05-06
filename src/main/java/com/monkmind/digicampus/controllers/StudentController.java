package com.monkmind.digicampus.controllers;

import com.monkmind.digicampus.models.Gender;
import com.monkmind.digicampus.models.Parent;
import com.monkmind.digicampus.models.Person;
import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
