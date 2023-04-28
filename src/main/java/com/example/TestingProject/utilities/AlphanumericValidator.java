package com.example.TestingProject.utilities;

import com.example.TestingProject.annotations.Alphanumeric;
import com.example.TestingProject.services.ServiceValidationMethods;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AlphanumericValidator implements ConstraintValidator<Alphanumeric, String> {
    @Override
    public boolean isValid(String a, ConstraintValidatorContext constraintValidatorContext) {
        return ServiceValidationMethods.alphanumericValidation(a);
    }
}
