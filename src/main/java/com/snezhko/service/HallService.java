package com.snezhko.service;

import com.snezhko.entity.HallEntity;

import java.util.ArrayList;

public interface HallService {
    void changeTheme(HallEntity hallEntity);
    void create(HallEntity hallEntity);
    HallEntity getById(int id);
    ArrayList<HallEntity> getAll();
}
