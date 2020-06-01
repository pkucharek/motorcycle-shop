package com.kucharek.motorcycleshop.service;

import com.kucharek.motorcycleshop.data.Offer;
import com.kucharek.motorcycleshop.data.OfferRepository;
import com.kucharek.motorcycleshop.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public List<Offer> findAll() {
        return offerRepository.findAll();
    }
}
