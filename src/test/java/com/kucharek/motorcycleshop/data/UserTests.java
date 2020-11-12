package com.kucharek.motorcycleshop.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTests {

    @Test
    void user_can_buy_offer_if_is_not_the_owner_and_has_enough_money() {
        User seller = new User();
        User buyer = userWithBalance(1000L);
        Offer offer = motorcycleOffer(seller, 500L);

        assertThat(buyer.canBuyMotorcycle(offer)).isTrue();
    }

    @Test
    void user_cant_buy_offer_if_has_enough_money_but_is_the_owner() {
        User seller = userWithBalance(1000L);
        Offer offer = motorcycleOffer(seller, 500L);

        assertThat(seller.canBuyMotorcycle(offer)).isFalse();
    }

    @Test
    void user_can_buy_offer_is_has_enough_money_and_is_not_the_owner() {
        User seller = new User();
        User buyer = userWithBalance(1000L);
        Offer offer = motorcycleOffer(seller, 500L);

        assertThat(buyer.canBuyMotorcycle(offer)).isTrue();
    }

    @Test
    void user_cant_buy_offer_if_not_has_enough_money_and_is_not_the_owner() {
        User seller = new User();
        User buyer = userWithBalance(100L);
        Offer offer = motorcycleOffer(seller, 500L);

        assertThat(buyer.canBuyMotorcycle(offer)).isFalse();
    }

    private User userWithBalance(long balance) {
        return User.builder()
                .balance(balance)
                .build();
    }

    private Offer motorcycleOffer(User seller, long price) {
        return Offer.builder()
                .owner(seller)
                .motorcycle(new Motorcycle())
                .price(price)
                .build();
    }
}
