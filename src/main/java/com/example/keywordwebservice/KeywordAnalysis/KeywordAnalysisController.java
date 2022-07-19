package com.example.keywordwebservice.KeywordAnalysis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class KeywordAnalysisController {
    final static String keywordAnalysis = "/chartTest";

    @GetMapping("/keywordAnalysis")
    public String keywordAnalysis(){
        return keywordAnalysis;

    }

    @GetMapping("/Analysis")
    @ResponseBody
    public Analysis Analysis(Model model){

        return new Analysis(List.of(1,2,3));
    }



}
