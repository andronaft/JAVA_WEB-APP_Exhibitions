package com.snezhko.repository;

import com.snezhko.entity.HallEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepo extends CrudRepository<HallEntity, Integer> {
}
