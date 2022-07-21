package com.example.keywordwebservice.KeywordAnalysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Date;
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
    public AnalysisDto Analysis(Model model){
        AnalysisDto analysisDto = AnalysisDto.builder().
                trend(List.of(1,2,3,4,5,6,7)).
                trend_Datetime(List.of("1", "2", "3", "4", "5", "6", "7"))
                .build();
        return analysisDto;
    }



}
