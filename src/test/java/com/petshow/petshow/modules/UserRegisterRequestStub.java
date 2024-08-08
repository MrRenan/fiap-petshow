package com.petshow.petshow.modules;

import com.github.javafaker.Faker;
import com.petshow.petshow.dto.UserRegisterRequest;

public class UserRegisterRequestStub {

    private static final Faker faker = new Faker();

    public static UserRegisterRequest userRegisterRequest() {
        return UserRegisterRequest.builder()
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .build();
    }
}
