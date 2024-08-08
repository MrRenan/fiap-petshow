package com.petshow.petshow.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserRegisterRequest {

    private String email;
    private String password;

}