package fr.nadeva.javaee.beanvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoYopMailValidator implements ConstraintValidator<NoYopmail, String> {
    @Override
    public void initialize(NoYopmail noYopmail) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s == null || !s.endsWith("yopmail.com");
    }
}
