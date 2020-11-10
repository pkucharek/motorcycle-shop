package com.kucharek.motorcycleshop.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTests {

    @Test
    void user_can_buy_offer_if_is_not_the_owner_and_has_enough_money() {
        User seller = new User();
        User buyer = User.builder()
                .balance(1000L)
                .build();

        Offer offer = Offer.builder()
                .owner(seller)
                .motorcycle(new Motorcycle())
                .price(500L)
                .build();

        boolean canBuy = buyer.canBuyMotorcycle(offer);

        assertThat(canBuy).isTrue();
    }

    @Test
    void user_cant_buy_offer_if_has_enough_money_but_is_the_owner() {
        User seller = User.builder()
                .balance(1000L).build();

        Offer offer = Offer.builder()
                .owner(seller)
                .motorcycle(new Motorcycle())
                .price(500L)
                .build();

        boolean canBuy = seller.canBuyMotorcycle(offer);

        assertThat(canBuy).isFalse();
    }

}
