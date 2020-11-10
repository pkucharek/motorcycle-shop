package com.kucharek.motorcycleshop.data;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class OfferAssert {

    private Offer offer;

    OfferAssert(Offer offer) {
        this.offer = offer;
    }

    static OfferAssert then(Offer offer) {
        return new OfferAssert(offer);
    }

    OfferAssert hasSubmittedToday() {
        Calendar today = Calendar.getInstance();
        assertThat(offer.getSubmissionDate().get(Calendar.YEAR)).isEqualTo(today.get(Calendar.YEAR));
        assertThat(offer.getSubmissionDate().get(Calendar.MONTH)).isEqualTo(today.get(Calendar.MONTH));
        assertThat(offer.getSubmissionDate().get(Calendar.DAY_OF_MONTH)).isEqualTo(today.get(Calendar.DAY_OF_MONTH));
        return this;
    }
}
