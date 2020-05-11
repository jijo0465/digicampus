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

    @RequestMapping("/login")
    public String getLoginPage(Model model){

        return "login";
    }

    @PostMapping
    @RequestMapping(value = "/{userType}/validate")
    public String validateLogin(@PathVariable String userType,@ModelAttribute User user, Model model){
        System.out.println(userType);
        User dbUser = userService.getUserByLoginId(user.getLoginId());

        if (dbUser!=null) {
            if (dbUser.getPassword().compareTo(user.getPassword()) == 0){
                model.addAttribute("userType",userType);
                return "index";
            }else{
                model.addAttribute("message","Invalid Password");
                return "login";
            }
        }else{
            model.addAttribute("message","Invalid UserId");
            return "login";
        }

    }

}
