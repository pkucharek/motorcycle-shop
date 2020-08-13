package com.kucharek.motorcycleshop.service;

import com.kucharek.motorcycleshop.data.Offer;
import com.kucharek.motorcycleshop.data.OfferRepository;
import com.kucharek.motorcycleshop.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Calendar;
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
    public List<Offer> findUserOffers(User buyer) {
        return offerRepository.findByBuyer(buyer);
    }

    @Override
    public void save(Offer offer) {
        motorcycleService.save(offer.getMotorcycle());
        offerRepository.save(offer);
    }

    @Override
    public Long getNextId() {
        return offerRepository.getNextOfferId();
    }

    @Override
    public Offer findById(int id) {
        return offerRepository.findById((long) id).get();
    }

    @Scheduled(cron = "0 0 0 * * *")
    @Override
    public void scheduledExpireOffers() {
        Calendar actualDate = Calendar.getInstance();
        List<Offer> offersToExpire = offerRepository
                .findByExpireDateBeforeAndExpiredIsFalse(actualDate);
        for (Offer offer : offersToExpire) {
            offer.setExpired(true);
        }
        offerRepository.saveAll(offersToExpire);
    }
}
