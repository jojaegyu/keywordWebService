package com.example.keywordwebservice.User;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SignUpValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return SignUpRequestDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignUpRequestDto sign = (SignUpRequestDto) target;
        if (!sign.getPassword().equals(sign.getConfirm_password())){
            errors.rejectValue("signUpRequestDto", "비밀번호가 다릅니다.", "비밀번호가 다릅니다.");
        }




    }
}
