package com.example.validate;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.example.dto.RegisterForm;

@Component
public class RegisterValidate implements Validator {
    @Autowired
    private UserService userService ;

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterForm.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        RegisterForm RV = (RegisterForm) object;
        if (!userService.register(RV)){
            errors.rejectValue("username","username","Exist");
        }
        if(!RV.getPassword().equals(RV.getRePassword())){
            errors.rejectValue("repPassword","username","not same");
        }
    }
}
