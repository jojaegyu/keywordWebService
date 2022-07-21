package com.example.keywordwebservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//@SpringBootTest
class KeywordWebServiceApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    public void javaTest(){

        Calendar calendar = Calendar.getInstance();

        List<LocalDateTime> dateTimeList = new ArrayList<>();
        for(int i = 1 ;i < 30; i++){
            calendar.add(Calendar.DAY_OF_WEEK, -i);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(calendar.getTime().toInstant(), ZoneId.systemDefault());
            System.out.println(localDateTime);
        }

    }

}
