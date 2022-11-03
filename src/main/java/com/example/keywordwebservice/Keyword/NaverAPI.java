package com.example.keywordwebservice.Keyword;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@RequiredArgsConstructor
@PropertySource("classpath:application-API-Key.properties")
public class NaverAPI {
    private final ObjectMapper mapper;

    @Value("${NaverTrendApiKey}")
    private String clientId;

    @Value("${NaverTrendApiSecret}")
    private String clientSecret;

    public TrendResponseDto call(TrendRequestDto trendRequestDto) {
        String keyword = trendRequestDto.getKeyword();
        String period = trendRequestDto.getPeriod();
        String gender = trendRequestDto.getGender();
        int ageCategory = Integer.parseInt(trendRequestDto.getAgeCategory());

        String request = "";

        ArrayList<Map<String, Object>> keywordGroups = new ArrayList<>();
        Map<String, Object> keywordGroup = new HashMap<>();
        List<String> periods = new ArrayList<>();
        List<Float> ratios = new ArrayList<>();
        Map<String, String> time = checkTime(period);

        keywordGroup.put("groupName", keyword);
        keywordGroup.put("keywords", Arrays.asList(keyword));
        keywordGroups.add(keywordGroup);

        String apiUrl = "https://openapi.naver.com/v1/datalab/search";

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        requestHeaders.put("Content-Type", "application/json");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("startDate", time.get("start"));
        requestBody.put("endDate", time.get("end"));
        requestBody.put("timeUnit", period);
        requestBody.put("keywordGroups", keywordGroups);
//        requestBody.put("device", "pc");
        requestBody.put("ages", getAgeList(ageCategory));

        if (!gender.equals("-1")){
            requestBody.put("gender", gender);
        }

        try {
            request = mapper.writeValueAsString(requestBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String responseBody = post(apiUrl, requestHeaders, request);
        try {
            Map<String, Object> map = mapper.readValue(responseBody, Map.class);
            List<Object> tmp = (ArrayList)map.get("results");
            LinkedHashMap hashMap = (LinkedHashMap) tmp.get(0);
            ArrayList data = (ArrayList) hashMap.get("data");
            for(Object value : data){
                Object val = ((LinkedHashMap) value).get("ratio");
                Object date = ((LinkedHashMap) value).get("period");
                if (val.getClass() == Double.class) {
                    ratios.add((Float) ((Double) val).floatValue());
                } else {
                    ratios.add((Float) ((Integer) val).floatValue());
                }
                periods.add(date.toString());
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return TrendResponseDto.builder()
                .periods(periods)
                .ratios(ratios)
                .build();
    }

    private static Map<String, String> checkTime(String period) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, String> map = new HashMap<String, String>();
        Calendar start_time = Calendar.getInstance();
        Calendar end_time = Calendar.getInstance();

        if (period.equals("date")){
            start_time.add(Calendar.DATE, -12);
        }
        if (period.equals("week")){
            start_time.add(Calendar.WEEK_OF_YEAR, -12);
        }
        if (period.equals("month")){
            start_time.add(Calendar.MONTH, -12);
        }

        Date start = new Date(start_time.getTimeInMillis());
        Date end = new Date(end_time.getTimeInMillis());
        map.put("start", simpleDateFormat.format(start));
        map.put("end", simpleDateFormat.format(end));

        return map;
    }

    private static List<String> getAgeList(int ageCategory){
        if (ageCategory == 0) {
            return Arrays.asList("1");
        }
        if (ageCategory == 1){
            return Arrays.asList("2");
        }
        if (ageCategory == 2){
            return Arrays.asList("3", "4");
        }
        if (ageCategory == 3){
            return Arrays.asList("5", "6");
        }
        if (ageCategory == 4){
            return Arrays.asList("7", "8");
        }
        if (ageCategory == 5){
            return Arrays.asList("9", "10");
        }
        if (ageCategory == 6){
            return Arrays.asList("11");
        }
        return Arrays.asList();
    }

    private static String post(String apiUrl, Map<String, String> requestHeaders, String requestBody) {
        HttpURLConnection con = connect(apiUrl);

        try {
            con.setRequestMethod("POST");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(requestBody.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(con.getInputStream());
            } else {  // 에러 응답
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect(); // Connection을 재활용할 필요가 없는 프로세스일 경우
        }
    }

    private static HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body, StandardCharsets.UTF_8);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}
