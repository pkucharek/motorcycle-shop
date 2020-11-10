package com.kucharek.motorcycleshop.data;

import org.junit.jupiter.api.Test;

import static com.kucharek.motorcycleshop.data.OfferAssert.then;

public class OfferTests {

    @Test
    void new_offer_has_submission_date_of_today() {
        then(new Offer()).hasSubmittedToday();
    }
}
