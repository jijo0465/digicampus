package com.monkmind.digicampus.controllers;

import com.monkmind.digicampus.models.User;
import com.monkmind.digicampus.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login/{user}")
    public String getLoginPage(@PathVariable String user,Model model){

        return "login";
    }

    @PostMapping
    @RequestMapping(value = "/validate")
    public String validateLogin(@ModelAttribute User user, Model model){
        User dbUser = userService.getUserByUsername(user.getLoginId());
        User dbUser2 = userService.getUserByUsernameAndPassword(user.getLoginId(),user.getPassword());
        if (dbUser2==null){
            System.out.println("Username and Password Mismatch");
        }

        if (dbUser!=null) {
            if (dbUser.getPassword().compareTo(user.getPassword()) == 0){
                return "Success";
            }else{
                return "Incorrect Password";
            }
        }else{
            return "Incorrect Username";
        }

    }

}
