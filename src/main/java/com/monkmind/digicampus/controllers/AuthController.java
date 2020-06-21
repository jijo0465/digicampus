package com.monkmind.digicampus.controllers;

import com.monkmind.digicampus.command.LoginCommand;
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
	
	
	private boolean loginval=false;
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
        return "fragments/dc-components/dc-screen-layout/dc-login";
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
        		
        		loginval=true;
            	return "fragments/dc-components/dc-screen-layout/dc-dashboard.html";
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
    	
    
    

    @RequestMapping(value="/mydashboard" , method=RequestMethod.GET)
    public String dashboard(Model model)
    {
    	if(loginval==true)
    	{
    	return "fragments/dc-components/dc-screen-layout/dc-dashboard.html";
    	}
    	else
    	{
    	return "loginfinal";
    	}
    }
    
    }
    


