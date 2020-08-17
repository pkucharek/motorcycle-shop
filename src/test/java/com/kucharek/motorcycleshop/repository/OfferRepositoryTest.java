package com.kucharek.motorcycleshop.repository;

import com.kucharek.motorcycleshop.data.Offer;
import com.kucharek.motorcycleshop.data.OfferRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OfferRepositoryTest {

    @Autowired
    private OfferRepository offerRepository;

    @Test
    public void whenFindById1_returnNotNullObject() {
        Optional<Offer> offer = offerRepository.findById((long) 1);
        assertThat(offer.get()).isNotNull();
    }

    @Test
    public void whenFindById1_returnOfferWithImageYamahaFazer() {
        Optional<Offer> offer = offerRepository.findById((long) 1);
        assertThat(offer.get().getImageName()).isEqualTo("yamaha-fazer.jpg");
    }

    @Test
    public void whenGetNextOfferId_return6() {
        Long nextId = offerRepository.getNextOfferId();
        assertThat(nextId).isEqualTo(6);
    }
}
