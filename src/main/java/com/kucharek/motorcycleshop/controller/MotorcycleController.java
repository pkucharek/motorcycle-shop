package com.kucharek.motorcycleshop.controller;

import com.kucharek.motorcycleshop.data.Motorcycle;
import com.kucharek.motorcycleshop.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/motorcycles")
public class MotorcycleController {

    @Autowired
    private MotorcycleService motorcycleService;

    @GetMapping("/list")
    public String listMotorcycles(Model model) {
        List<Motorcycle> motorcycles = motorcycleService.findAll();
        model.addAttribute("motorcycles", motorcycles);
        return "motorcycles/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute("motorcycle", new Motorcycle());
        return "motorcycles/add-motorcycle-form";
    }

    @PostMapping("/save")
    public String saveMotorcycle(@Valid Motorcycle motorcycle, Errors errors) {
        if (errors.hasErrors())
            return "motorcycles/form";

        motorcycleService.save(motorcycle);
        return "redirect:/motorcycles/list";
    }
}
