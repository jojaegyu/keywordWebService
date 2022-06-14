package com.example.keywordwebservice.User;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

import java.util.Optional;

@SpringBootTest
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void userSaveTest(){
        User user = User.builder()
                .email("jojaegyu@gmail.com")
                .password("password")
                .phone_number("01030766244")
                .name("jojaegyu")
                .build();
        userRepository.save(user);

        User retrieveUser = userRepository.findById(user.getId()).get();

        Assertions.assertThat(user.getEmail()).isEqualTo(retrieveUser.getEmail());
        Assertions.assertThat(user.getName()).isEqualTo(retrieveUser.getName());
        Assertions.assertThat(user.getPassword()).isEqualTo(retrieveUser.getPassword());
        Assertions.assertThat(user.getPhone_number()).isEqualTo(retrieveUser.getPhone_number());



    }



}
