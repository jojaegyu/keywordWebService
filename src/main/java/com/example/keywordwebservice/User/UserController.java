package com.example.keywordwebservice.User;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class UserController {
    private static final String signupMain = "/User/signupform";
    private static final String loginMain = "/User/loginform";
    private final UserService userService;

    @GetMapping("/signup")
    public String getSignup(Model model) {
        model.addAttribute("SignUpRequestDto", new SignUpRequestDto());
        return signupMain;
    }

    @PostMapping("/signup")
    public String postSignup(@Valid @ModelAttribute(name = "SignUpRequestDto") SignUpRequestDto signUpRequestDto,
                             BindingResult bindingResult) {

        userService.signup(signUpRequestDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return signupMain;
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("LoginRequestDto", new LoginRequestDto());
        return loginMain;
    }

    @PostMapping("/login")
    public String checkLogin(@Valid @ModelAttribute(name = "LoginRequestDto") LoginRequestDto loginRequestDto,
                             BindingResult bindingResult, HttpSession httpSession){

        userService.login(loginRequestDto, bindingResult);

        if(bindingResult.hasErrors()){
            return loginMain;
        }

        return "redirect:/";
    }
}
