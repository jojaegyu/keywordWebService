package com.example.keywordwebservice.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository repository;

    @Transactional
    public void save(SignUpRequestDto signUpRequestDto){
        repository.save(signUpRequestDto.toEntity());
    }



}
