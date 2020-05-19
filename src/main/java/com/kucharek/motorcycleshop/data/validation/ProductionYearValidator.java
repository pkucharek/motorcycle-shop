package com.kucharek.motorcycleshop.data.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Year;

public class ProductionYearValidator
    implements ConstraintValidator<ProductionYearConstraint, Year> {

    @Override
    public boolean isValid(Year year, ConstraintValidatorContext context) {
        return year != null && year.getValue() >= 1885 &&
                year.getValue() <= Year.now().getValue() ;
    }
}
