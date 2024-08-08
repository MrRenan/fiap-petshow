package com.petshow.petshow.repository;

import com.petshow.petshow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    boolean existsByEmail(String email);

    UserEntity findByEmail(String email);
}
