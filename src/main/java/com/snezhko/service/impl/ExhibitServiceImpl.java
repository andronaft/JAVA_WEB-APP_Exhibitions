package com.snezhko.service.impl;

import com.snezhko.entity.ExhibitEntity;
import com.snezhko.repository.ExhibitRepo;
import com.snezhko.service.ExhibitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("ExhibitServiceImpl")
@Repository
@Transactional
public class ExhibitServiceImpl implements ExhibitService {
    private final ExhibitRepo exhibitRepo;

    @Autowired
    public ExhibitServiceImpl(ExhibitRepo exhibitRepo){
        this.exhibitRepo = exhibitRepo;
    }

    @Override
    public void create(ExhibitEntity exhibitEntity) {
        exhibitRepo.save(exhibitEntity);
    }

    @Override
    public ExhibitEntity getById(int id) {
        return exhibitRepo.findOne(id);
    }

    @Override
    public void changeHallId(ExhibitEntity exhibitEntity) {
        exhibitRepo.save(exhibitEntity);
    }

    @Override
    public ArrayList<ExhibitEntity> getAll() {
        return (ArrayList<ExhibitEntity>) exhibitRepo.findAll();
    }
}