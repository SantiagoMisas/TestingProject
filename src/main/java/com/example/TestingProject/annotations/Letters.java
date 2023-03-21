package com.example.TestingProject.annotations;

import com.example.TestingProject.utilities.LettersValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LettersValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Letters {
    String message() default "This field must be filled only with words, no numbers or special characters.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
