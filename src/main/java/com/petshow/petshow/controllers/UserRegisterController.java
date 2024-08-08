package com.petshow.petshow.controllers;

import com.petshow.petshow.dto.UserRegisterRequest;
import com.petshow.petshow.dto.UserRegisterResponse;
import com.petshow.petshow.exception.UserAlreadyExistsException;
import com.petshow.petshow.modules.userRegister.UserRegisterMapper;
import com.petshow.petshow.service.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.petshow.petshow.controllers.UserRegisterController.API_USER_REGISTER;

@RequiredArgsConstructor
@RestController
@RequestMapping(API_USER_REGISTER)
public class UserRegisterController {

    static final String API_USER_REGISTER = "/petshow/v1/userRegister";

    private final UserRegisterService service;

    private final UserRegisterMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<UserRegisterResponse> createUser(
            @RequestBody UserRegisterRequest request
    ) {

        var userRegisterEntity = service.create(request);
        var userRegisterResponse = mapper.toUserRegisterResponse(userRegisterEntity);

        return ResponseEntity.ok(userRegisterResponse);

    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }
}