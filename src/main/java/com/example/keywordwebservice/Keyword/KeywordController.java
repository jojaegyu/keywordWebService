package com.example.keywordwebservice.Keyword;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class KeywordController {
    private static final String analysis = "/analysis/analysis";

    private final NaverAPI naverAPI;

    @GetMapping("/analysis")
    public String getAnalysis(Model model, @RequestParam String keyword){
        model.addAttribute("keyword", keyword);
        model.addAttribute("KeywordRequestDto", new KeywordRequestDto());
        return analysis;
    }

    @GetMapping("/getTrend")
    @ResponseBody
    public TrendResponseDto getTrend(@ModelAttribute TrendRequestDto trendRequestDto, Model model) {
        TrendResponseDto trendResponseDto = naverAPI.call(trendRequestDto);
        return trendResponseDto;
    }



}
