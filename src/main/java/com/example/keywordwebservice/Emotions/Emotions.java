package com.example.keywordwebservice.Emotions;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Arrays;


@NoArgsConstructor
@Setter
@Getter
@Entity
public class Emotions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    String keyword;

    int angry;

    int sad;

    int fear;

    int disgust;

    int neutral;

    int happiness;

    int surprise;

}
