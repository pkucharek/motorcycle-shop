package com.kucharek.motorcycleshop.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTests {

    @Test
    void user_can_buy_offer_if_is_not_the_owner_and_has_enough_money() {
        User seller = new User();
        User buyer = new User();
        buyer.setBalance(1000L);

        Offer offer = new Offer();
        offer.setOwner(seller);
        offer.setMotorcycle(new Motorcycle());
        offer.setPrice(500L);

        boolean canBuy = buyer.canBuyMotorcycle(offer);

        assertThat(canBuy).isTrue();
    }

}
