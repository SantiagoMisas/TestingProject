package com.example.TestingProject.annotations;

import com.example.TestingProject.utilities.NumbersValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NumbersValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Numbers {
    String message() default "This field must be filled in only numbers, no letters or special characters.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
