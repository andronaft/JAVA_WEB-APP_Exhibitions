package com.snezhko.service;

import com.snezhko.entity.UserEntity;

import java.util.ArrayList;

public interface UserService {

    UserEntity login(UserEntity userEntity);
    void registration(UserEntity userEntity);
    UserEntity getById(UserEntity userEntity);
    ArrayList<UserEntity> getAll(UserEntity admin);
    boolean isAdmin(UserEntity admin);
}
