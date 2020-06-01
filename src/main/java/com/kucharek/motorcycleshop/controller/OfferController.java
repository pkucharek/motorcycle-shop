package com.kucharek.motorcycleshop.controller;

import com.kucharek.motorcycleshop.data.Motorcycle;
import com.kucharek.motorcycleshop.data.Offer;
import com.kucharek.motorcycleshop.data.User;
import com.kucharek.motorcycleshop.service.MotorcycleService;
import com.kucharek.motorcycleshop.service.OfferService;
import com.kucharek.motorcycleshop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
public class OfferController {

    @Autowired
    private UserService userService;

    @Autowired
    private OfferService offerService;

    @GetMapping("/")
    public String listOffers(Model model) {
        List<Offer> offers = offerService.findAll();
        model.addAttribute("offers", offers);
        return "offer/list-offers";
    }

    @GetMapping("/offers/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute("offer", new Offer());
        return "offer/add-offer-form";
    }

    @PostMapping("/offers/save")
    public String saveOffer(@Valid Offer offer, Errors errors, Authentication auth) {
        if (errors.hasErrors())
            return "offer/form";

        User user = userService.findByUserName(auth.getName());
        offer.setOwner(user);
        offer.setExpired(false);

        offerService.save(offer);
        return "redirect:/";
    }
}
