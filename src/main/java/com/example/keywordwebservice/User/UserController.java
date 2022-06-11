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
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class UserController {
    private static final String signupMain = "/User/signupform";
    private static final String logInMain = "/User/logInform";
    private final UserService userService;

    @GetMapping("/signup")
    public String getSignup(Model model) {
        model.addAttribute("SignUpRequestDto", new SignUpRequestDto());
        return signupMain;
    }

    @PostMapping("/signup")
    public String postSignup(@Valid SignUpRequestDto signUpRequestDto,
                             BindingResult bindingResult) {

        if (!signUpRequestDto.getPassword().equals(signUpRequestDto.getConfirm_password())){
            bindingResult.rejectValue("confirm_password",
                    "비밀번호가 다릅니다.", "비밀번호가 다릅니다.");
        }
        if (bindingResult.hasErrors()) {
            return signupMain;
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("LogInRequestDto", new LogInRequestDto());
        return logInMain;
    }

    @PostMapping("/login")
    public String checkLogin(@Valid LogInRequestDto logInRequestDto,
                             BindingResult bindingResult){



    }
}
