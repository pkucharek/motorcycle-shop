package com.kucharek.motorcycleshop.data;

import org.junit.jupiter.api.Test;

import static com.kucharek.motorcycleshop.data.OfferAssert.then;

public class OfferTests {

    @Test
    void new_offer_has_submission_date_of_today() {
        then(offer()).hasSubmittedToday();
    }

    @Test
    void new_offer_has_expire_date_30_days_after_today() {
        then(offer()).expireMonthLater();
    }

    private Offer offer() {
        return new Offer();
    }
}
