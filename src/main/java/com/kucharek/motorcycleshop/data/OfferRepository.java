package com.kucharek.motorcycleshop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Calendar;
import java.util.List;

public interface OfferRepository
    extends JpaRepository<Offer, Long> {

    List<Offer> findOffersByExpiredIsFalse();
    List<Offer> findByBuyer(User buyer);

    List<Offer> findByExpireDateBeforeAndExpiredIsFalse(Calendar actualDate);

    @Query(value = "SELECT AUTO_INCREMENT\n" +
            "FROM information_schema.TABLES\n" +
            "where TABLE_NAME = \"offer\";", nativeQuery = true)
    Long getNextOfferId();
}
