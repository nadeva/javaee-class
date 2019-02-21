package fr.nadeva.javaee.beanvalidation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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


        user.setTwitter("@ere");
        user.setHobbies(Arrays.asList("golf", "tv", "twitter"));

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertEquals("No violations should be found", 0, violations.size());
    }

    @Test
    public void invalidUser() {
        User user = new User();
        user.setEmail("test@email.com");
        user.setName("John Doe");
        user.setBeginWorkingDate(LocalDate.of(2017, 1, 1));
        user.setBirthDate(LocalDate.of(2017, 1, 1));
        user.setHobbies(Arrays.asList("golf", "tv", "twitter"));
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals("One violation should be found", 1, violations.size());
        assertTrue(violations.stream().anyMatch(constraintViolation -> constraintViolation.getMessage().equals("User dates inconsistent")));
    }

    @Test
    public void shouldRaise2ConstraintViolations() {
        User user = new User();
        user.setBirthDate(LocalDate.of(2017, 1, 1));
        user.setHobbies(Arrays.asList("golf", "tv", "twitter"));

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals("2 violations should be found", 2, violations.size());
    }

    @Test
    public void checkMethod() throws NoSuchMethodException {
        User user = new User();
        user.setHobbies(Arrays.asList("golf", "tv", "twitter"));

        final Method method = User.class.getMethod("setExperienceAge", Integer.class);
        Set<ConstraintViolation<User>> violations = validator.forExecutables().validateParameters(user, method, new Object[]{Integer.valueOf(1)});
        assertEquals("1 violation should be found", 1, violations.size());
    }

    @Test
    public void shouldRaiseConstraintViolation() {

        User user = new User();
        user.setEmail("wrongemail");
        user.setName("John Doe");
        user.setHobbies(Arrays.asList("golf", "", "twitter"));

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals("2 violations should be found", 2, violations.size());

    }

    @Test
    public void checkNoYopMail() {

        User user = new User();
        user.setEmail("test@yopmail.com");
        user.setName("John Doe");
        user.setHobbies(Arrays.asList("golf", "tv", "twitter"));

        user.setBirthDate(LocalDate.of(2017, 1, 1));
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals(1, violations.size());

    }
}
