package com.snezhko.repository;

import com.snezhko.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends CrudRepository<TransactionEntity, Integer> {
}
