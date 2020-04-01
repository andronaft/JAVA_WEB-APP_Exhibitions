package com.snezhko.repository;

import com.snezhko.entity.ExhibitEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitRepo extends CrudRepository<ExhibitEntity, Integer> {
}
