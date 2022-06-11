package com.example.keywordwebservice.User;

import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    @Size(max=20)
    private String email;

    @Size(max=20)
    private String password;

    @Size(max=11)
    private String name;

    @Size(max=11)
    private String phone_number;

    private int age;

    @Column(columnDefinition = "TINYINT")
    private int gender;

    @Builder
    public User(Long id, String email, String password, String name, String phone_number, int age, int gender) {
        Id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
        this.age = age;
        this.gender = gender;
    }
}
