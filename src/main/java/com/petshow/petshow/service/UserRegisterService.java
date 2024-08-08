package com.petshow.petshow.service;

import com.petshow.petshow.dto.UserRegisterRequest;
import com.petshow.petshow.entity.UserEntity;
import com.petshow.petshow.exception.UserAlreadyExistsException;
import com.petshow.petshow.modules.userRegister.UserRegisterMapper;
import com.petshow.petshow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegisterService {

    private UserRepository repository;
    private final UserRegisterMapper mapper;

    public UserEntity create(UserRegisterRequest request) {
        if(repository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("Usuário já cadastrado: " + request.getEmail());
        }
        UserEntity userRegisterEntity = mapper.toUserRegisterEntity(request);
        return repository.save(userRegisterEntity);

    }

}