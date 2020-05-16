package com.kucharek.motorcycleshop.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.Year;

@Data
@NoArgsConstructor
@Entity
@Table
public class Motorcycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    @NotBlank(message = "Brand is obligatory")
    private String brand;

    @Column
    @NotBlank(message = "Model is obligatory")
    private String model;

    @Column
    @NotBlank(message = "Color is obligatory")
    private String color;

    @Column
    @NotBlank(message = "Type is obligatory")
    private String type;

    @Convert(converter = YearAttributeConverter.class)
    @Column(name = "production_year")
    @NotNull(message = "Production year is obligatory")
    @ProductionYearConstraint(message = "Production year should be between 1885 and current year")
    private Year productionYear;

    @Column
    @NotNull(message = "Cylinders are obligatory")
    @Min(value = 1, message = "Cylinders number should be between 1 and 12")
    @Max(value = 12, message = "Cylinders number should be between 1 and 12")
    private byte cylinders;

    @Column
    @NotNull(message = "Engine capacity is obligatory")
    @Min(value = 1, message = "Engine capacity should be between 1 and 3000")
    @Max(value = 3000, message = "Engine capacity should be between 1 and 3000")
    private short engineCapacity;

}
