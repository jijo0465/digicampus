package com.monkmind.digicampus.controllers;

import com.monkmind.digicampus.command.LoginCommand;
import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.models.Teacher;
import com.monkmind.digicampus.models.User;
import com.monkmind.digicampus.services.StudentService;
import com.monkmind.digicampus.services.TeacherService;
import com.monkmind.digicampus.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    private final UserService userService;
    private final StudentService studentService;
    private final TeacherService teacherService;

    public AuthController(UserService userService,StudentService studentService,TeacherService teacherService) {
        this.userService = userService;
        this.studentService=studentService;
        this.teacherService=teacherService;
    }

    @RequestMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginCommand",new LoginCommand());
        return "login";
    }

    @PostMapping
    @RequestMapping(value = "/{userType}/validate")
    public String validateLogin(@PathVariable String userType,@ModelAttribute User user, Model model){
        System.out.println(userType);
        User dbUser = userService.getUserByLoginId(user.getLoginId());
        /*shijina*/
        if (dbUser!=null) {
            if (dbUser.getPassword().compareTo(user.getPassword()) == 0){
               // model.addAttribute("userType",userType);

//                if (dbUser!=null) {
//                    if (dbUser.getPassword().compareTo(user.getPassword()) == 0){
//                        model.addAttribute("userType",userType);
//                        return "success :: success";
//                    }else{
//                        model.addAttribute("message","Invalid Password");
//                        return "login";
//                    }
//                }
             if (userType.compareTo("admin")==0)
            {
            	model.addAttribute("userType",userType);
            	return "adminhome";
            }

            else if(userType.compareTo("student")==0)
            {
            	Student student=studentService.getStudentByStudentId(dbUser.getLoginId());
            	model.addAttribute("student",student);
            	model.addAttribute("userType",userType);
            	System.out.println(student.getName());
            	return "studdisplay";
             }
            else if(userType.compareTo("teacher")==0)
            {
            	Teacher teacher=teacherService.getTeacherByTeacherId(dbUser.getLoginId());
            	model.addAttribute("teacher",teacher);
            	model.addAttribute("userType",userType);
            	System.out.println(teacher.getName());
            	return "teacherdisplay";
            }
            return "index";
            }
            else{
            	model.addAttribute("message","Invalid Password");
                return "login";
            }
        }else{
            model.addAttribute("message","Invalid UserId");
            return "login";
        }

    }

}
