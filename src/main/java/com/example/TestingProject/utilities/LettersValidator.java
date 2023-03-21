package com.example.TestingProject.utilities;

import com.example.TestingProject.annotations.Letters;
import com.example.TestingProject.services.ServiceValidationMethods;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LettersValidator implements ConstraintValidator<Letters, String> {

    @Override
    public boolean isValid(String l, ConstraintValidatorContext constraintValidatorContext) {
        return ServiceValidationMethods.lettersValidation(l);
    }
}
