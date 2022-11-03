package com.example.keywordwebservice.User;

import lombok.RequiredArgsConstructor;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository repository;

    @Transactional
    public void save(SignUpRequestDto signUpRequestDto){
        repository.save(signUpRequestDto.toEntity());
    }

    @Transactional
    public void login(LoginRequestDto loginRequestDto, BindingResult bindingResult){
        Optional<User> user = repository.findByEmail(loginRequestDto.getEmail());
        String real_password;

        if (user.isPresent()){
            real_password = user.get().getPassword();
        }
        else{
            bindingResult.rejectValue("password", "해당 아이디가 존재하지 않습니다.", "해당 아이디가 존재하지 않습니다.");
            return;
        }

        if (!real_password.equals(loginRequestDto.getPassword())){
            bindingResult.rejectValue("password", "비밀번호가 다릅니다", "비밀번호가 다릅니다");
        }
    }

    @Transactional
    public void signup(SignUpRequestDto signUpRequestDto, BindingResult bindingResult){
        if (!signUpRequestDto.getPassword().equals(signUpRequestDto.getConfirm_password())){
            bindingResult.rejectValue("confirm_password",
                    "비밀번호가 다릅니다.", "비밀번호가 다릅니다.");
        }
        try{
            repository.save(signUpRequestDto.toEntity());
        } catch (Exception exception){
            bindingResult.rejectValue("email", "이메일이 이미 있습니다.", "이메일이 이미 있습니다.");
        }
    }



}
