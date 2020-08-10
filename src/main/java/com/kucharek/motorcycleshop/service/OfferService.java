package com.kucharek.motorcycleshop.service;

import com.kucharek.motorcycleshop.data.Offer;
import com.kucharek.motorcycleshop.data.User;

import java.util.List;

public interface OfferService {

    List<Offer> findAllNotExpired();
    List<Offer> findUserOffers(User owner);

    void save(Offer offer);

    Offer findById(int id);
}
