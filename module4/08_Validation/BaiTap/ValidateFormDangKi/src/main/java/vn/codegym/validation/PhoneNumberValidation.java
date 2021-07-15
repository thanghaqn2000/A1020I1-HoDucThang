package vn.codegym.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidation implements ConstraintValidator<PhoneNumber,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        if(!value.startsWith("0"))
            return false;
        return value.matches("[0-9]{10}");
    }
}
