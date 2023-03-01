package com.anhlam.petrang.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IDValidate implements ConstraintValidator<ALamID, String> {
    private static final String ALam_PREFIX = "Alam";

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isEmpty()) return false;

        return s.startsWith(ALam_PREFIX);
    }
}
