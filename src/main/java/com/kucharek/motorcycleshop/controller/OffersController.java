package com.kucharek.motorcycleshop.controller;

import com.kucharek.motorcycleshop.data.Motorcycle;
import com.kucharek.motorcycleshop.data.Offer;
import com.kucharek.motorcycleshop.service.MotorcycleService;
import com.kucharek.motorcycleshop.service.OfferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/motorcycles")
public class OffersController {

    @Autowired
    private MotorcycleService motorcycleService;

    @Autowired
    private OfferService offerService;

    @GetMapping("/list")
    public String listOffers(Model model) {
        List<Offer> offers = offerService.findAll();
        model.addAttribute("offers", offers);
        return "motorcycles/list-motorcycles";
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
