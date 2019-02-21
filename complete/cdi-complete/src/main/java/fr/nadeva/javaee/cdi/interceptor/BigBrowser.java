package fr.nadeva.javaee.cdi.interceptor;

import javax.interceptor.Interceptor;
import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@InterceptorBinding
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD})
public @interface BigBrowser {
}
