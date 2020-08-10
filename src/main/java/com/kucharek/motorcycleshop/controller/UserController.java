package com.kucharek.motorcycleshop.controller;

import com.kucharek.motorcycleshop.data.Offer;
import com.kucharek.motorcycleshop.data.User;
import com.kucharek.motorcycleshop.service.OfferService;
import com.kucharek.motorcycleshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OfferService offerService;

    @GetMapping("/panel")
    public String showUserPanel(Principal principal, Model model) {
        User user = saveUserToModelAndReturn(principal, model);
        saveOffersBoughtByUserToModel(model, user);
        return "user/panel";
    }

    @GetMapping("/charge")
    public String chargeUser(Principal principal, Model model) {
        User user = saveUserToModelAndReturn(principal, model);
        userService.chargeUser(principal.getName());
        saveOffersBoughtByUserToModel(model, user);
        return "user/panel";
    }

    private User saveUserToModelAndReturn(Principal principal, Model model) {
        String username = principal.getName();
        User user = userService.findByUserName(username);
        model.addAttribute("user", user);
        return user;
    }

    private void saveOffersBoughtByUserToModel(Model model, User user) {
        List<Offer> userOffers = offerService.findUserOffers(user);
        model.addAttribute("offers", userOffers);
    }



}
