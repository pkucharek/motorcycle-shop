package com.kucharek.motorcycleshop.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Year;

@Data
@NoArgsConstructor
@Entity
@Table
public class Motorcycle {

    @Id
    @GeneratedValue
    @Column
    private long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private String color;

    @Column
    private String type;

    @Convert(converter = YearAttributeConverter.class)
    @Column(name = "production_year")
    private Year productionYear;

    @Column
    private byte cylinders;

    @Column
    private short engineCapacity;

}
