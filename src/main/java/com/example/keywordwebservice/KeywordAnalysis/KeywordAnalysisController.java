package com.example.keywordwebservice.KeywordAnalysis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class KeywordAnalysisController {
    final static String keywordAnalysis = "/KeywordAnalysis/AnalysisForm";

    @GetMapping("/keywordAnalysis")
    public String keywordAnalysis(){
        return keywordAnalysis;

    }

    @GetMapping("/Analysis")
    @ResponseBody
    public AnalysisResponseDto Analysis(Model model){
        AnalysisResponseDto analysisResponseDto = AnalysisResponseDto.builder().
                trend(List.of(1,2,3,4,5,6,7)).
                trend_Datetime(List.of("1", "2", "3", "4", "5", "6", "7"))
                .emotions(List.of(0.2f, 0.2f, 0.2f, 0.1f, 0.1f, 0.1f, 0.1f))
                .build();
        return analysisResponseDto;
    }





}
