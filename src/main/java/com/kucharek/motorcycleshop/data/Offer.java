package com.kucharek.motorcycleshop.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Calendar;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@Table
public class Offer {

    public Offer() {
        submissionDate = new Date(System.currentTimeMillis());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 30);
        expireDate = calendar.getTime();
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
    private Date submissionDate;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column
    private Long price;

    @Column(name = "expire_date")
    private Date expireDate;

    @Column
    private boolean expired;


}
