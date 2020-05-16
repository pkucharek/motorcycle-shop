package com.kucharek.motorcycleshop.controller;

import com.kucharek.motorcycleshop.data.Motorcycle;
import com.kucharek.motorcycleshop.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MotorcycleController {

    @Autowired
    private MotorcycleService motorcycleService;

    @GetMapping
    public String homePage(Model model) {
        List<Motorcycle> motorcycles = motorcycleService.findAll();
        model.addAttribute("motorcycles", motorcycles);
        return "home";
    }
}
