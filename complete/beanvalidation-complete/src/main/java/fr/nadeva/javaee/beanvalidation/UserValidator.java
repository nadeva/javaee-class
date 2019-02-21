package fr.nadeva.javaee.beanvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserValidator implements ConstraintValidator<UserValid, User> {
    @Override
    public void initialize(UserValid userValid) {

    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        return user.getBeginWorkingDate() == null ||
                (user.getBirthDate() != null && user.getBeginWorkingDate() != null && user.getBeginWorkingDate().isAfter(user.getBirthDate()));
    }
}
