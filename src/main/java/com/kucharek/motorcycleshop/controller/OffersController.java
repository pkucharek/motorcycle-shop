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
public class OffersController {

    @Autowired
    private OfferService offerService;

    @GetMapping("/")
    public String listOffers(Model model) {
        List<Offer> offers = offerService.findAll();
        model.addAttribute("offers", offers);
        return "offer/list-offers";
    }

    @GetMapping("/offer/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute("offer", new Offer());
        return "offer/add-offer-form";
    }

    @PostMapping("/offer/save")
    public String saveOffer(@Valid Offer offer, Errors errors) {
        if (errors.hasErrors())
            return "offer/form";

        offerService.save(offer);
        return "redirect:/";
    }
}
