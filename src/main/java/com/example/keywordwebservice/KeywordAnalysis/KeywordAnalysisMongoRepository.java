package com.example.keywordwebservice.KeywordAnalysis;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface KeywordAnalysisMongoRepository extends MongoRepository<Analysis, ObjectId> {
    Optional<Analysis> findAnalysisByKeyword(String keyword);
}