package com.example.keywordwebservice.KeywordAnalysis;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Analysis {

    @Indexed(unique = true)
    private String keyword;

    private List<Integer> trend;

    private List<String> trend_DateTime;

    @Builder
    public Analysis(String keyword, List<Integer> trend, List<String> trend_DateTime) {
        this.keyword = keyword;
        this.trend = trend;
        this.trend_DateTime = trend_DateTime;
    }

    public AnalysisResponseDto toDto(){
        return AnalysisResponseDto.builder()
                .trend(trend)
                .trend_Datetime(trend_DateTime)
                .build();

    }
}
