package com.petshow.petshow.modules.userRegister;

import com.petshow.petshow.dto.UserRegisterRequest;
import com.petshow.petshow.dto.UserRegisterResponse;
import com.petshow.petshow.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRegisterMapper {

    UserRegisterResponse toUserRegisterResponse(UserEntity userRegisterEntity);

    UserEntity toUserRegisterEntity(UserRegisterRequest userRegisterRequest);

}