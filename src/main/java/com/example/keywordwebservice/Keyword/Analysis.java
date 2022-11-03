package com.example.keywordwebservice.Keyword;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "analysis")
public class Analysis {
    @Id
    private String id;

    private String name;
}


