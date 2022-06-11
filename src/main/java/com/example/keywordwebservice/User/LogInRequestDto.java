package com.example.keywordwebservice.User;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
public class LogInRequestDto {
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @Builder
    public LogInRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
