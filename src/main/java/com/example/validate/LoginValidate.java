package com.example.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.example.dto.SignInForm;
@Component
public class LoginValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return SignInForm.class.equals(clazz);

    }

    @Override
    public void validate(Object obj, Errors errors) {

        SignInForm signInForm = (SignInForm) obj;

        if (signInForm.getUsername().trim().isEmpty() || signInForm.getPassword().trim().isEmpty()){
            errors.rejectValue("username","username","Not Empty");
        }
    }


}
