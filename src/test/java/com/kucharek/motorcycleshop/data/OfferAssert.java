package com.kucharek.motorcycleshop.data;

import java.util.Calendar;
import java.util.List;

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
        areDatesEqual(offer.getSubmissionDate(), today);
        return this;
    }

    OfferAssert expireMonthLater() {
        Calendar monthLater = Calendar.getInstance();
        monthLater.add(Calendar.DATE, 30);
        areDatesEqual(offer.getExpireDate(), monthLater);
        return this;
    }

    private void areDatesEqual(Calendar comparing, Calendar toCompare) {
        List.of(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH)
            .forEach(typeOfDate -> assertThat(comparing.get(typeOfDate)).isEqualTo(toCompare.get(typeOfDate)));
    }
}
