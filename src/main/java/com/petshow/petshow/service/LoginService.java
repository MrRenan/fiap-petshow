package com.petshow.petshow.service;

import com.petshow.petshow.dto.LoginRequest;
import com.petshow.petshow.entity.UserEntity;
import com.petshow.petshow.exception.InvalidPasswordException;
import com.petshow.petshow.exception.UserNotFoundException;
import com.petshow.petshow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private UserRepository repository;

    public UserEntity login(LoginRequest request){

        var byUsername = repository.findByEmail(request.getEmail());

        if(byUsername == null) {
            throw new UserNotFoundException("Usuário já cadastrado: " + request.getEmail());
        } else if (request.getPassword().equals(byUsername.getPassword())){
            throw new InvalidPasswordException("Senha inválida.");
        }
        return byUsername;
    }
}
