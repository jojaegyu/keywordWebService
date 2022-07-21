package com.example.keywordwebservice.KeywordAnalysis;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AnalysisDto {
    private List<Integer> trend;

    private List<String> trend_Datetime;

    @Builder
    public AnalysisDto(List<Integer> trend, List<String> trend_Datetime) {
        this.trend = trend;
        this.trend_Datetime = trend_Datetime;
    }
}
