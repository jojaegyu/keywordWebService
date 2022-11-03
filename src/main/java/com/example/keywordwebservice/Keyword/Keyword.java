package com.example.keywordwebservice.Keyword;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Id;
import java.util.List;

@Document(collection = "keyword")
@Getter
@Setter
public class Keyword {

    @Id
    private String id;

    @Indexed(unique = true)
    private String keyword;

    private String name;


    private List<String> arr;

    @Builder
    public Keyword(String keyword, String name) {
        this.keyword = keyword;
        this.name = name;
    }
}
