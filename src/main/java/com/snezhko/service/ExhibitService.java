package com.snezhko.service;

import com.snezhko.entity.ExhibitEntity;

import java.util.ArrayList;

public interface ExhibitService {
    void create(ExhibitEntity exhibitEntity);
    ExhibitEntity getById(int id);
    void changeHallId(ExhibitEntity exhibitEntity);
    ArrayList<ExhibitEntity> getAll();

}
