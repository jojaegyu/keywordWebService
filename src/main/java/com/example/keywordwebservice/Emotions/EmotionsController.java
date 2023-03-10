package com.example.keywordwebservice.Emotions;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class EmotionsController {
    private final EmotionsRepository emotionsRepository;

    @PostMapping("/postEmotions")
    @ResponseBody
    public void postEmotions(@ModelAttribute Emotions emotions){
        emotionsRepository.save(emotions);
        return;

    }

    @GetMapping("/getEmotions")
    @ResponseBody
    public EmotionsResponseDto getEmotions(@ModelAttribute EmotionsRequestDto emotionsRequestDto){
        Optional<Emotions> emotions = emotionsRepository.findByKeyword(emotionsRequestDto.getKeyword());
        if (emotions.isPresent()){
            Emotions tmp;
            tmp = emotions.get();
            return new EmotionsResponseDto(new ArrayList<Integer>(Arrays.asList(tmp.getAngry(), tmp.getSad(), tmp.getDisgust(), tmp.getNeutral()
            , tmp.getHappiness(), tmp.getSurprise())));
        }
        return new EmotionsResponseDto(new ArrayList<Integer>(Arrays.asList(14, 16, 13, 11, 19, 14, 13)));
    }
}
