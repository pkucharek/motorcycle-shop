package com.kucharek.motorcycleshop.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Data
@AllArgsConstructor
@Entity
@Table
public class Offer {

    public Offer() {
        submissionDate = Calendar.getInstance();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 30);
        expireDate = calendar;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @Valid
    @OneToOne
    @JoinColumn(name = "motorcycle_id")
    private Motorcycle motorcycle;

    @Column(name = "submission_date")
    private Calendar submissionDate;

    @Column(name = "purchase_date")
    private Calendar purchaseDate;

    @NotNull(message = "{offer.notNull}")
    @Min(value = 1, message = "{offer.price.min}")
    @Max(value = 999_999_999, message = "{offer.price.max}")
    @Column
    private Long price;

    @Column(name = "expire_date")
    private Calendar expireDate;

    @Column
    private boolean expired;

    public String generateTitle() {
        return "Szczegóły oferty " + getId()
                + " Motocykl " + getMotorcycle().getBrand()
                + " " + getMotorcycle().getModel();
    }

    public String getPurchaseDateString() {
        int year = purchaseDate.get(Calendar.YEAR);
        int month = purchaseDate.get(Calendar.MONTH) + 1;
        int day = purchaseDate.get(Calendar.DAY_OF_MONTH);
        return String.format("%04d", year)
                + "-" + String.format("%02d", month)
                + "-" + String.format("%02d", day);
    }

}
