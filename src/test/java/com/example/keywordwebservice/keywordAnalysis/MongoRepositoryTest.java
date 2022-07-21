package com.example.keywordwebservice.keywordAnalysis;


import com.example.keywordwebservice.KeywordAnalysis.Analysis;
import com.example.keywordwebservice.KeywordAnalysis.KeywordAnalysisMongoRepository;
import org.apache.tomcat.jni.Local;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MongoRepositoryTest {
    @Autowired
    KeywordAnalysisMongoRepository mongoRepository;

    @Test
    public void select(){
        Analysis analysis = Analysis.builder().
                keyword("camera")
                .trend(List.of(1,2,3,4,5,6))
                .trend_DateTime(List.of("2022-07-15", "2022-07-16", "2022-07-18", "2022-07-19", "2022-07-20", "2022-07-21"))
                        .build();
        mongoRepository.insert(analysis);
//        mongoRepository.insert(analysis);
        System.out.println(mongoRepository.findAll());
        Optional<Analysis> analysis1 = mongoRepository.findAnalysisByKeyword("camera");
        if (analysis1.isPresent()){
            Analysis analysis2 = analysis1.get();
            System.out.println(analysis2.getKeyword());
            assertThat(analysis.getKeyword()).isEqualTo(analysis2.getKeyword());
        }
        mongoRepository.deleteAll();
    }

    @Test
    public void insert(){
        Analysis analysis = Analysis.builder().keyword("not test").trend(List.of(1,2,3)).build();
        mongoRepository.insert(analysis);
        List<Analysis> analysisList = mongoRepository.findAll();
        System.out.println(analysisList.get(0).getTrend());


        mongoRepository.deleteAll();
    }




}
