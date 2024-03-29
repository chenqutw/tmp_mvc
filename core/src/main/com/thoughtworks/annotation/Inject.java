package main.com.thoughtworks.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({CONSTRUCTOR,METHOD})
@Retention(RUNTIME)
public @interface Inject {
}
