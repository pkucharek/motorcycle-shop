package com.kucharek.motorcycleshop.service;

import com.kucharek.motorcycleshop.data.Offer;
import com.kucharek.motorcycleshop.data.OfferRepository;
import com.kucharek.motorcycleshop.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public List<Offer> findAll() {
        return offerRepository.findAll();
    }

    @Override
    public void save(Offer offer) {
        offerRepository.save(offer);
    }

    private void initializeOffer(Offer offer) {
        Date submissionDate = new Date(System.currentTimeMillis());
        offer.setSubmissionDate(submissionDate);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 30);
        Date expiredDate = calendar.getTime();
        offer.setExpireDate(expiredDate);
    }
}
