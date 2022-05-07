package com.example.keywordwebservice.User;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserSignUpController {
    private static final String signupMain = "/User/signupform";

    @GetMapping("/signup")
    public String signup(){


        return signupMain;
    }

}
