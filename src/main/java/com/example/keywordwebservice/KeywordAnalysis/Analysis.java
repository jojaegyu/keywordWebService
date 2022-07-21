package com.example.keywordwebservice.KeywordAnalysis;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import java.util.ArrayList;
import java.util.Date;
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
    public AnalysisDto toDto(){
        return AnalysisDto.builder()
                .trend(trend)
                .trend_Datetime(trend_DateTime)
                .build();

    }
}
