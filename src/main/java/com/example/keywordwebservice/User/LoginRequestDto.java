package com.example.keywordwebservice.User;

import lombok.*;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@Getter
@Setter
public class LoginRequestDto {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @Builder
    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
