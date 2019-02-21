package fr.nadeva.javaee.beanvalidation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = NoYopMailValidator.class)
public @interface NoYopmail {
    String message() default "This email is a yopmail one";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
