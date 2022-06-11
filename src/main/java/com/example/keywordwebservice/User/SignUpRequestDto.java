package com.example.keywordwebservice.User;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@RequiredArgsConstructor
@Getter
@Setter
public class SignUpRequestDto {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    @NotBlank
    @Size(min = 8, max = 20)
    private String confirm_password;

    @NotBlank
    @Size(min = 2, max = 10)
    private String name;

    @NotBlank
    @Size(min = 11, max = 11)
    private String phone_number;

    @Max(150)
    private int age;

    // 여 0 남 1
    @Max(1)
    private int gender;

    public User toEntity(){
        return User.builder()
                .email(email)
                .password(password)
                .name(name)
                .phone_number(phone_number)
                .build();
    }


    @Builder
    public SignUpRequestDto(String email, String password, String confirm_password, String name, String phone_number, int age, int gender) {
        this.email = email;
        this.password = password;
        this.confirm_password = confirm_password;
        this.name = name;
        this.phone_number = phone_number;
        this.age = age;
        this.gender = gender;
    }
}
