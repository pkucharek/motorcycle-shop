package com.kucharek.motorcycleshop.controller;

import com.kucharek.motorcycleshop.data.Offer;
import com.kucharek.motorcycleshop.data.User;
import com.kucharek.motorcycleshop.service.OfferService;
import com.kucharek.motorcycleshop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.List;

@Slf4j
@Controller
public class OfferController {

    @Autowired
    private UserService userService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private StorageService storageService;

    @GetMapping("/")
    public String listOffers(Model model) {
        List<Offer> offers = offerService.findAllNotExpired();
        model.addAttribute("offers", offers);
        return "offer/list-offers";
    }

    @GetMapping("/files")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(String offerId, String filename) {

        Resource file = storageService.loadAsResource(offerId, filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment;").body(file);
    }

    @GetMapping("/offers/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute("offer", new Offer());
        return "offer/add-offer-form";
    }

    @PostMapping("/offers/save")
    public String saveOffer(@Valid Offer offer, Errors errors, Authentication auth,
                            @RequestParam("file") MultipartFile file, Model model) {
        if (errors.hasErrors())
            return "offer/add-offer-form";

        User user = userService.findByUserName(auth.getName());
        offer.setOwner(user);
        offer.setExpired(false);
        String fileName = StringUtils.cleanPath(
                Objects.requireNonNull(file.getOriginalFilename())
        );

        offer.setImageName(fileName);
        Long nextId = offerService.getNextId();
        try {
            storageService.store(file, nextId.toString());
        } catch (StorageException e) {
            model.addAttribute("imageError", "Zdjęcie jest wymagane!");
            return "offer/add-offer-form";
        }

        offerService.save(offer);
        return "redirect:/";
    }

    @GetMapping("/offer/{id}")
    public String getOfferById(Model model, @PathVariable int id) {
        Offer offer = offerService.findById(id);
        model.addAttribute("offer", offer);
        return "offer/current-offer";
    }

    @GetMapping("/offer/showDetailsToBuy/{id}")
    public String getDetailsToBuy(Model model,
                                  @PathVariable int id,
                                  Authentication auth,
                                  RedirectAttributes redirectAttributes) {
        Offer offer = offerService.findById(id);
        model.addAttribute("offer", offer);
        User user = userService.findByUserName(auth.getName());
        model.addAttribute("user", user);
        String offerTitle = offer.generateTitle();
        model.addAttribute("offerTitle", offerTitle);
        if (user.canBuyMotorcycle(offer)) {
            long balanceAfterPurchase =
                    user.getBalanceAfterPossiblePurchase(offer);
            model.addAttribute("balanceAfterPurchase", balanceAfterPurchase);
            return "/offer/details-to-buy";
        }
        if (user.equals(offer.getOwner())) {
            redirectAttributes.addAttribute("state", "same_user");
        }
        if (user.getBalanceAfterPossiblePurchase(offer) < 0) {
            redirectAttributes.addAttribute("state", "low_money");
        }
        return "redirect:/offer/" + id;
    }

    @GetMapping("/buyOffer/{id}")
    public String performPurchase(
            Model model, @PathVariable int id,
            Authentication auth) {
        Offer offer = offerService.findById(id);

        User buyer = userService.findByUserName(auth.getName());
        long buyerBalanceAfterPurchase = buyer.getBalanceAfterPossiblePurchase(offer);
        buyer.setBalance(buyerBalanceAfterPurchase);

        User owner = offer.getOwner();
        long ownerBalanceAfterPurchase = owner.getBalance() + offer.getPrice();
        owner.setBalance(ownerBalanceAfterPurchase);

        offer.setBuyer(buyer);
        Calendar purchaseDate = Calendar.getInstance();
        offer.setPurchaseDate(purchaseDate);
        offer.setExpired(true);

        offerService.save(offer);
        userService.saveUser(owner);
        userService.saveUser(buyer);

        return "offer/successful-purchase";
    }
}
