package com.example.keywordwebservice.User;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Rollback(false)
public class LoginTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    public void loginTest() throws Exception {
        SignUpRequestDto signUpRequestDto = SignUpRequestDto.builder()
                .email("jojaegyu@gmail.com")
                .password("password")
                .phone_number("01030766244")
                .name("jojaegyu")
                .age(26)
                .gender(1)
                .build();

        User user = signUpRequestDto.toEntity();
        userRepository.save(user);

        User retrieve_user = userRepository.findByEmail("jojaegyu@gmail.com").get();
        assertThat(user.getPassword()).isEqualTo(retrieve_user.getPassword());
        assertThat(user.getName()).isEqualTo(retrieve_user.getName());
        assertThat(user.getPhone_number()).isEqualTo(retrieve_user.getPhone_number());
        assertThat(user.getAge()).isEqualTo(retrieve_user.getAge());
        assertThat(user.getGender()).isEqualTo(retrieve_user.getGender());

        mockMvc.perform(post("/login").param("email",
                        signUpRequestDto.getEmail())
                        .param("password", signUpRequestDto.getPassword()))
                .andExpect(status().is3xxRedirection())
                .andDo(print());





    }

}
