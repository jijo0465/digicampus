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

    @GetMapping({"/login","/"," ","/dashboard"})
    public String getLoginPage(Model model){
        model.addAttribute("logincommand",new LoginCommand());
        return "fragments/dc-components/dc-screen-layout/dc-login/dc-login";
    }

    @PostMapping(path="/dashboard")
    public String validateLogin(@ModelAttribute LoginCommand logincommand, Model model){
        User dbUser = userService.getUserByLoginId(logincommand.getLoginId());

        if (dbUser!=null) {

            if (dbUser.getPassword().compareTo(logincommand.getPassword()) == 0){


                if(dbUser.getUsertype()==UserType.ADMIN) {

                    loginval=true;
                    return "fragments/dc-components/dc-screen-layout/dc-dashboard/dc-dashboard";
                }
                else if(dbUser.getUsertype()==UserType.TEACHER) {

                    return "adminhome";
                }
                else if(dbUser.getUsertype()==UserType.STUDENT) {

                    return "fragments/formbutton:: formbutton";
                }
                return "fragments/dc-components/dc-screen-layout/dc-login/dc-login";
            }
            else{
                model.addAttribute("message","Invalid Password");
                return "fragments/dc-components/dc-screen-layout/dc-login/dc-login";
            }

        }
        else {
            return "fragments/dc-components/dc-screen-layout/dc-login/dc-login";
        }
    }




    @GetMapping(value="/mydashboard")
    public String dashboard(Model model)
    {
        if(loginval==true)
        {
            return "fragments/dc-components/dc-screen-layout/dc-dashboard/dc-dashboard";
        }
        else
        {
            return "fragments/dc-components/dc-screen-layout/dc-login/dc-login";
        }
    }

}
    


