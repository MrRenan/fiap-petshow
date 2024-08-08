package com.petshow.petshow.controllers;

import com.petshow.petshow.dto.LoginRequest;
import com.petshow.petshow.exception.UserNotFoundException;
import com.petshow.petshow.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.petshow.petshow.controllers.LoginController.API_LOGIN;

@RequiredArgsConstructor
@RestController
@RequestMapping(API_LOGIN)
public class LoginController {

    static final String API_LOGIN = "/petshow/v1/login";

    private final LoginService service;

    @PostMapping
    public ResponseEntity<String> login(
            @RequestBody LoginRequest request
    ) {

        var userEntity = service.login(request);

        return ResponseEntity.ok("");
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
