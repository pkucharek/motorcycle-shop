package com.kucharek.motorcycleshop.data;

import com.kucharek.motorcycleshop.data.validation.ProductionYearConstraint;
import com.kucharek.motorcycleshop.data.validation.YearAttributeConverter;
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
    @NotBlank(message = "{motorcycle.brand.notBlank}")
    private String brand;

    @Column
    @NotBlank(message = "{motorcycle.model.notBlank}")
    private String model;

    @Column
    @NotBlank(message = "{motorcycle.color.notBlank}")
    private String color;

    @Column
    @NotBlank(message = "{motorcycle.type.notBlank}")
    private String type;

    @Convert(converter = YearAttributeConverter.class)
    @Column(name = "production_year")
    @NotNull(message = "{motorcycle.productionYear.notNull}")
    @ProductionYearConstraint(message = "{motorcycle.productionYear.productionYearConstraint}")
    private Year productionYear;

    @Column
    @NotNull(message = "{motorcycle.cylinders.notNull}")
    @Min(value = 1, message = "{motorcycle.cylinders.badValue}")
    @Max(value = 12, message = "{motorcycle.cylinders.badValue}")
    private byte cylinders;

    @Column
    @NotNull(message = "{motorcycle.engineCapacity.notNull}")
    @Min(value = 1, message = "{motorcycle.engineCapacity.badValue}")
    @Max(value = 3000, message = "{motorcycle.engineCapacity.badValue}")
    private short engineCapacity;

}
