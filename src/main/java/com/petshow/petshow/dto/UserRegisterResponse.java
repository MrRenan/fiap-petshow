package com.petshow.petshow.dto;

import lombok.Builder;

@Builder
public record UserRegisterResponse(

        String password,
        String email
) {
}