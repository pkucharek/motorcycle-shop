package com.kucharek.motorcycleshop.service;

import com.kucharek.motorcycleshop.data.Offer;
import com.kucharek.motorcycleshop.data.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private MotorcycleService motorcycleService;

    @Override
    public List<Offer> findAllNotExpired() {
        return offerRepository.findOffersByExpiredIsFalse();
    }

    @Override
    public void save(Offer offer) {
        motorcycleService.save(offer.getMotorcycle());
        offerRepository.save(offer);
    }

    @Override
    public Offer findById(int id) {
        return offerRepository.findById((long) id).get();
    }
}
