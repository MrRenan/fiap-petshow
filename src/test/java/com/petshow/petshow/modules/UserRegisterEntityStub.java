package com.petshow.petshow.modules;

import com.github.javafaker.Faker;
import com.petshow.petshow.entity.UserEntity;

import java.util.UUID;

public class UserRegisterEntityStub {
    private static final Faker faker = new Faker();

    public static UserEntity userRegisterEntity(){
        return UserEntity.builder()
                .id(UUID.randomUUID().toString())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .build();
    }
}
