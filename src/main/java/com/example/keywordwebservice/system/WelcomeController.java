package com.example.keywordwebservice.system;

import com.example.keywordwebservice.KeywordAnalysis.AnalysisRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome(Model model){

        AnalysisRequestDto analysisRequestDto = new AnalysisRequestDto();
        model.addAttribute("AnalysisRequestDto", analysisRequestDto);
        return "welcome";
    }

}
