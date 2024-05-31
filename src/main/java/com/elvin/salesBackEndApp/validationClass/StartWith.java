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
    ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE
})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StartwithValidator.class)
@Documented
public @interface StartWith {
    String value();
    String message() default "Phone number must start with 08";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

class StartwithValidator implements ConstraintValidator<StartWith, String> {

    private String prefix;

    @Override  
    public void initialize(StartWith constraintAnnotation) {
        this.prefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // TODO Auto-generated method stub
        return value != null && value.startsWith("08");
    }

}
