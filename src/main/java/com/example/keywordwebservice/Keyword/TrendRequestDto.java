package com.example.keywordwebservice.Keyword;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrendRequestDto {
    String keyword;

    String period;

    String gender;

    String ageCategory;

    @Builder
    public TrendRequestDto(String keyword, String period, String gender, String ageCategory) {
        this.keyword = keyword;
        this.period = period;
        this.gender = gender;
        this.ageCategory = ageCategory;
    }
}
