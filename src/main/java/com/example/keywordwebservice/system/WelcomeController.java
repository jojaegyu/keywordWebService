package com.example.keywordwebservice.system;

import com.example.keywordwebservice.Keyword.KeywordRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome(Model model){
        model.addAttribute("KeywordRequestDto", new KeywordRequestDto());
        return "welcome";
    }

}
