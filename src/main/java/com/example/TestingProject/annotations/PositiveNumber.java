package com.example.TestingProject.annotations;

import com.example.TestingProject.utilities.PositiveNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PositiveNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PositiveNumber {
    String message() default "This field should only be filled with positive numbers, it does not admit letters or special characters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
