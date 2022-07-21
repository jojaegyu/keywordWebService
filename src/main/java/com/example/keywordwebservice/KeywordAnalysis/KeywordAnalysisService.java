package com.example.keywordwebservice.KeywordAnalysis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KeywordAnalysisService {

    private final KeywordAnalysisMongoRepository mongoRepository;

    public void insertAnalysis(Analysis analysis){
        mongoRepository.insert(analysis);
    }

    public AnalysisDto selectAnalysis(String keyword){
        Optional<Analysis> analysis= mongoRepository.findAnalysisByKeyword(keyword);
        if (analysis.isPresent()){
            return analysis.get().toDto();
        }
//        LocalDateTime.now().toString()
//        AnalysisDto nullAnalysisDto = AnalysisDto.builder()
//                .trend(List.of(0, 0, 0, 0, 0, 0))
//                .trend_Datetime();
        return analysis.get().toDto();
    }


}
