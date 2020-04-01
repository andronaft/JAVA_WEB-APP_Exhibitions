package com.snezhko.repository;

import com.snezhko.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Integer> {
    UserEntity findByLogin(String login);
}
