package com.example.TestingProject.utilities;

import com.example.TestingProject.annotations.PositiveNumber;
import com.example.TestingProject.services.ServiceValidationMethods;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PositiveNumberValidator implements ConstraintValidator<PositiveNumber, String> {
    @Override
    public boolean isValid(String n, ConstraintValidatorContext constraintValidatorContext) {
        return ServiceValidationMethods.positiveNumbersValidation(n);
    }
}

