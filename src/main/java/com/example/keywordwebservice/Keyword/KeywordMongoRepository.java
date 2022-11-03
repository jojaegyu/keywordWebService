package com.example.keywordwebservice.Keyword;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface KeywordMongoRepository extends MongoRepository<Keyword, String> {
    List<Keyword> findBykeyword(String keyword);
}
