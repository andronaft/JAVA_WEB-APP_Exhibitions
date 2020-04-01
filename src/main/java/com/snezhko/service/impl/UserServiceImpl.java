package com.snezhko.service.impl;

import com.snezhko.entity.UserEntity;
import com.snezhko.repository.UserRepo;
import com.snezhko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("UserServiceImpl")
@Repository
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserEntity login(UserEntity userEntity) {
        UserEntity findUser = userRepo.findByLogin(userEntity.getLogin());
        if(findUser.getPassword().equals(userEntity.getPassword())){
            return findUser;
        }
        return null;
    }

    @Override
    public void registration(UserEntity userEntity) {
        userRepo.save(userEntity);
    }

    @Override
    public UserEntity getById(UserEntity userEntity)
    {
        if(login(userEntity).getRole()=="admin"||login(userEntity).getPassword()==userEntity.getPassword()) {
            return  userRepo.findOne(userEntity.getId());
        }
        return null;
    }

    @Override
    public ArrayList<UserEntity> getAll(UserEntity admin) {
        if(isAdmin(admin)) {
            return (ArrayList<UserEntity>) userRepo.findAll();
        }
        return null;
    }

    @Override
    public boolean isAdmin(UserEntity admin) {
        if(login(admin).getRole()=="admin"){
            return true;
        }
        return false;
    }
}
