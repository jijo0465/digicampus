package com.monkmind.digicampus.controllers;

import com.monkmind.digicampus.command.LoginCommand;
import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.models.Teacher;
import com.monkmind.digicampus.models.User;
import com.monkmind.digicampus.models.UserType;
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
    	model.addAttribute("logincommand",new LoginCommand());
        return "loginfinal";
    }

   // @PostMapping
    /* @RequestMapping(value = "/dashboard")
  public String validateLogin(@ModelAttribute LoginCommand logincommand, Model model){
        System.out.println(logincommand.getLoginId());
        User dbUser = userService.getUserByLoginId(logincommand.getLoginId());
       
        if (dbUser!=null) {
            if (dbUser.getPassword().compareTo(logincommand.getPassword()) == 0){
            	//return "user";
               //return "fragments/formbutton:: formbutton";
            	if(dbUser.getUsertype()==UserType.ADMIN) {
                	
                	return "mydashboard";
                }
            	else if(dbUser.getUsertype()==UserType.TEACHER) {
                	
                	return "adminhome";
                }
            	else if(dbUser.getUsertype()==UserType.STUDENT) {
                	
                	return "fragments/formbutton:: formbutton";
                }
            	return "loginfinal";
                 }
            else{
                model.addAttribute("message","Invalid Password");
                return "loginfinal";
            }
            
        }
           else {
        	return "loginfinal";
        }
        }
*/
    
    @RequestMapping(value="/mydashboard")
    public String dashboard(Model model)
    {
    	return "rediect:/";
    }
    
    @PostMapping
    @RequestMapping(value="/dashboard")
    public String validateLogin(@ModelAttribute LoginCommand logincommand, Model model){
    System.out.println(logincommand.getLoginId());
    User dbUser = userService.getUserByLoginId(logincommand.getLoginId());
   
    if (dbUser!=null) {
        if (dbUser.getPassword().compareTo(logincommand.getPassword()) == 0){
        	//return "user";
           //return "fragments/formbutton:: formbutton";
        	if(dbUser.getUsertype()==UserType.ADMIN) {
            	
            	return "mydashboard";
            }
        	else if(dbUser.getUsertype()==UserType.TEACHER) {
            	
            	return "adminhome";
            }
        	else if(dbUser.getUsertype()==UserType.STUDENT) {
            	
            	return "fragments/formbutton:: formbutton";
            }
        	return "loginfinal";
             }
        else{
            model.addAttribute("message","Invalid Password");
            return "loginfinal";
        }
        
    }
       else {
    	return "loginfinal";
    }
    }
    	
    }
    



             
    /*if (dbUser!=null) {
    if (dbUser.getPassword().compareTo(logincommand.getPassword()) == 0){
              // model.addAttribute("userType",userType);
          if (logincommand.getLoginId().compareTo(logincommand.getPassword())== 0)
          {
//            //	model.addAttribute("userType",userType);
        	   return "adminhome";
       
          }
             */
              
      /*      else if(logincommand.getLoginId().length() == 7)
            {
            	Student student=studentService.getStudentByStudentId(dbUser.getLoginId());
           	model.addAttribute("student",student);
         	//model.addAttribute("userType",userType);
          	System.out.println(student.getName());
          	return "studdisplay";
            }
            else{
                model.addAttribute("message","Invalid Password");
                return "loginfinal";
            }
        } else {
        	return "loginfinal";
        }
         
       }
       */

    
    

     
//            else if(userType.compareTo("teacher")==0)
//            {
//            	Teacher teacher=teacherService.getTeacherByTeacherId(dbUser.getLoginId());
//            	model.addAttribute("teacher",teacher);
//            	model.addAttribute("userType",userType);
//            	System.out.println(teacher.getName());
//            	return "teacherdisplay";
//            }
//            return "index";
//            }
//            else{
//            	model.addAttribute("message","Invalid Password");
//                return "login";
//            }
//        }else{
//            model.addAttribute("message","Invalid UserId");
//            return "login";
  
    

    


