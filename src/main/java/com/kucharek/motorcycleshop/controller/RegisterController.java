package com.kucharek.motorcycleshop.controller;

import com.kucharek.motorcycleshop.user.FormUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @GetMapping
    public String showRegisterPage(Model model) {
        model.addAttribute("formUser", new FormUser());
        return "register-form";
    }
}
