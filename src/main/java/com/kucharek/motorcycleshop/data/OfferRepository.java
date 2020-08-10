package com.kucharek.motorcycleshop.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository
    extends JpaRepository<Offer, Long> {

    List<Offer> findOffersByExpiredIsFalse();
    List<Offer> findByBuyer(User buyer);
}
