package com.example.keywordwebservice.Emotions;

import java.util.ArrayList;
import java.util.Arrays;

public class EmotionsResponseDto {
    ArrayList<Integer> emotions;

    public EmotionsResponseDto(ArrayList<Integer> emotions) {
        this.emotions = emotions;
    }

    public ArrayList<Integer> getEmotions() {
        return emotions;
    }

    public void setEmotions(ArrayList<Integer> emotions) {
        this.emotions = emotions;
    }


    private EmotionsResponseDto toArrayList(Emotions emotions){
        return new EmotionsResponseDto(new ArrayList<>(Arrays.asList(emotions.angry,emotions.sad, emotions.fear, emotions.disgust, emotions.neutral
                , emotions.happiness, emotions.surprise)));
    }
}
