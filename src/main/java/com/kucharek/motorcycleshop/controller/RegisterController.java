package com.kucharek.motorcycleshop.controller;

import com.kucharek.motorcycleshop.data.User;
import com.kucharek.motorcycleshop.service.UserService;
import com.kucharek.motorcycleshop.user.FormUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegisterPage(Model model) {
        model.addAttribute("formUser", new FormUser());
        return "register-form";
    }

    @PostMapping
    public String processRegistrationForm(@Valid FormUser formUser,
                                          BindingResult bindingResult,
                                          Model model) {
        if (bindingResult.hasErrors()) {
            return "register-form";
        }

        User existing = userService.findByUserName(formUser.getUserName());

        if (existing != null) {
            model.addAttribute("formUser", new FormUser());
            model.addAttribute("registerError", "Username already exists");
            return "register-form";
        }

        userService.save(formUser);
        return "registration-confirmation";
    }

}
