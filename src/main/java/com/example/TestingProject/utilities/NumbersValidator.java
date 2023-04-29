package com.example.TestingProject.utilities;

import com.example.TestingProject.annotations.Numbers;
import com.example.TestingProject.services.ServiceValidationMethods;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumbersValidator implements ConstraintValidator<Numbers, String> {

    @Override
    public boolean isValid(String n, ConstraintValidatorContext constraintValidatorContext) {
        return ServiceValidationMethods.numbersValidation(n);
    }
}
