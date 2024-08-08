package com.petshow.petshow.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginRequest {

    private String email;
    private String password;

}
