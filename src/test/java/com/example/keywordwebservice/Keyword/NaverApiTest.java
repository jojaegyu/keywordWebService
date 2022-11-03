package com.example.keywordwebservice.Keyword;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestClientTest(NaverAPI.class)
public class NaverApiTest {
    @Autowired
    private static ObjectMapper mapper;

    @Autowired
    private NaverAPI api;

    @Test
    public void jsonToString(){
        TrendRequestDto trendRequestDto = TrendRequestDto.builder()
                .keyword("keyword")
                .period("month")
                .gender("-1")
                .ageCategory("-1")
                .build();
        System.out.println(api.call(trendRequestDto));

    }

}
