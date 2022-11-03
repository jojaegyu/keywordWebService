package com.example.keywordwebservice.Keyword;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TrendResponseDto {
    private List<String> periods;

    private List<Float> ratios;

    @Builder
    public TrendResponseDto(List<String> periods, List<Float> ratios) {
        this.periods = periods;
        this.ratios = ratios;
    }
}
