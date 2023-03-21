package com.example.TestingProject.annotations;

import com.example.TestingProject.utilities.AlphanumericValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AlphanumericValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Alphanumeric {
    String message() default "This field should must be filled with an alphanumeric expression, it does not admit special characters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
