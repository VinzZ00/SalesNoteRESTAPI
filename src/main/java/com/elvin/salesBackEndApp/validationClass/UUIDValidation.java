package com.elvin.salesBackEndApp.validationClass;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

@Target({
    ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, 
})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UUIDValidator.class)
@Documented
public @interface UUIDValidation {
    String message() default "Invalid order ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

class UUIDValidator implements ConstraintValidator<UUIDValidation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // TODO Auto-generated method stub
        return value != null && value.matches("[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}");
    }

}
