package com.monkmind.digicampus.controllers;

import com.monkmind.digicampus.command.LoginCommand;
import com.monkmind.digicampus.models.*;
import com.monkmind.digicampus.services.ParentService;
import com.monkmind.digicampus.services.TeacherService;
import com.monkmind.digicampus.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@AllArgsConstructor
@Controller
public class MobileAuthController {
    private final UserService userService;
    private final TeacherService teacherService;
    private final ParentService parentService;
    @ResponseBody
    @RequestMapping(value = "/login/teacher",produces = "application/json")
    public Person validateLogin(@RequestBody LoginCommand logincommand, Model model){
        System.out.println(logincommand.getLoginId());
        User dbUser = userService.getUserByLoginId(logincommand.getLoginId());

        if (dbUser!=null) {

            if (dbUser.getPassword().compareTo(logincommand.getPassword()) == 0){
                //return "user";
                //return "fragments/formbutton:: formbutton";

                if(dbUser.getUsertype()== UserType.PARENT) {
                    Parent parent = parentService.getParentByParentId(dbUser.getLoginId());

                    return parent;
                }
                else if(dbUser.getUsertype()== UserType.TEACHER) {
                    Teacher teacher = teacherService.getTeacherByTeacherId(dbUser.getLoginId());
                    return teacher;
                }
                else if(dbUser.getUsertype()== UserType.STUDENT) {

                    return null;
                }
                return null;
            }
            else{
                model.addAttribute("message","Invalid Password");
                return null;
            }

        }
        else {
            return null;
        }
    }
}
