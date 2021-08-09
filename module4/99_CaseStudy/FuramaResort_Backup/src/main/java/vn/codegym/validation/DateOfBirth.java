package vn.codegym.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DofValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DateOfBirth {
    String message() default "Customer's age must be more than 18";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
