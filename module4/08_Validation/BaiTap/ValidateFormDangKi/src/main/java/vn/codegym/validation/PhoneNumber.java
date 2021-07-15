package vn.codegym.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy =PhoneNumberValidation.class )
@Retention(RUNTIME)
@Target(FIELD)
public @interface PhoneNumber {
    String message() default "Phone must start with zero and length must be 10";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
