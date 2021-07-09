package be.vdab.ondernemingsnummer.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OndernemingsNummerValidator implements ConstraintValidator<OndernemingsNummer, Long> {
    public void initialize(OndernemingsNummer constraint) {
    }

    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        var laatste2Cijfers = value % 100;
        var overigeCijfers = value / 100;
        return laatste2Cijfers == 97 - overigeCijfers % 97;
    }
}
