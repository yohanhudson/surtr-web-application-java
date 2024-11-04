package com.projeto.surtr.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class AgeValidator implements ConstraintValidator<AgeRange, LocalDate> {

    private int minAge;

    @Override
    public void initialize(AgeRange age) {
        minAge = age.minAge();
    }

    @Override
    public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext context) {
        if (dateOfBirth == null) {
            return true;
        }
        LocalDate now = LocalDate.now();
        int age = Period.between(dateOfBirth, now).getYears();
        return age >= minAge;
    }
}
