package fr.nadeva.javaee.beanvalidation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.junit.Assert.assertEquals;

public class UserIT {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;


    @BeforeClass
    public static void init() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterClass
    public static void close() {
        validatorFactory.close();
    }

    @Test
    public void shouldRaiseNoConstraintViolation() {
        User user = new User();
        user.setEmail("test@email.com");
        user.setName("John Doe");
        user.setBirthDate(LocalDate.of(2017, 1, 1));
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals("No violations should be found", 0, violations.size());
    }


    //TODO
    @Test
    public void shouldRaise2ConstraintViolations() {
    }

}
