package com.kucharek.motorcycleshop.service;

import com.kucharek.motorcycleshop.data.Offer;

import java.util.List;

public interface OfferService {

    List<Offer> findAllNotExpired();

    void save(Offer offer);

    Offer findById(int id);
}
