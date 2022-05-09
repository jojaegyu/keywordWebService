package com.example.keywordwebservice.User;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    private static final String signupMain = "/User/signupform";

    @GetMapping("/signup")
    public String getSignup(Model model) {
        model.addAttribute("User", new User());
        return signupMain;
    }

    @PostMapping("/signup")
    public String postSignup(@Valid User user,
                             BindingResult bindingResult, Model model) {
        User u = User.builder()
                .email("jojaegyu@gmail.com")
                .password("password")
                .phone_number("01030766244")
                .name("jojaegyu")
                .build();
        model.addAttribute("User", user);
        System.out.println("a9ow8ir");
        if (bindingResult.hasErrors()) {
            return signupMain;
        }
        return "qqq";

    }
}
