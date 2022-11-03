package com.example.keywordwebservice.Keyword;

import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import org.assertj.core.api.Assertions;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Rollback(value = true)
public class MongoRepositoryTest {
    @Autowired
    KeywordMongoRepository repository;

    @Test
    public void mongoTest(){
        Keyword keyword = Keyword.builder()
                .keyword("qq2")
                .name("is good")
                .build();
        List<String> arr = new ArrayList<String>();
        arr.add("werwer25525");
        arr.add("werwer1");
        arr.add("werwer2");
        keyword.setArr(arr);
        try {
            Keyword keyword1 = repository.save(keyword);
        } catch (Exception e){
            System.out.println(e);
        }
        List<Keyword> keyword2 = repository.findBykeyword(keyword.getKeyword());
        Assertions.assertThat(keyword2.get(0).getKeyword()).isEqualTo("qq2");

        System.out.println(keyword2.get(0).getArr());
        System.out.println(keyword.getArr());
//        System.out.println(keyword2.get(0).getArr().get(1));
//        System.out.println(keyword2.get(0).getArr().get(2));

    }


}
