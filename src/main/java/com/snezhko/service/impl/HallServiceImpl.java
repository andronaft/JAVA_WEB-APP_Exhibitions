package com.snezhko.service.impl;

import com.snezhko.entity.HallEntity;
import com.snezhko.repository.HallRepo;
import com.snezhko.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("HallServiceImpl")
@Repository
@Transactional
public class HallServiceImpl implements HallService {
    private final HallRepo hallRepo;

    @Autowired
    public HallServiceImpl(HallRepo hallRepo){
        this.hallRepo = hallRepo;
    }

    @Override
    public void changeTheme(HallEntity hallEntity) {
        hallRepo.save(hallEntity);
    }

    @Override
    public void create(HallEntity hallEntity) {
        hallRepo.save(hallEntity);
    }

    @Override
    public HallEntity getById(int id) {
        return hallRepo.findOne(id);
    }

    @Override
    public ArrayList<HallEntity> getAll() {
        return (ArrayList<HallEntity>) hallRepo.findAll();
    }
}