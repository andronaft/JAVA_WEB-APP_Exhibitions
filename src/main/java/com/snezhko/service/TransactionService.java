package com.snezhko.service;

import com.snezhko.entity.TransactionEntity;
import com.snezhko.entity.UserEntity;

import java.util.ArrayList;

public interface TransactionService {
    void save(TransactionEntity transactionEntity);
    ArrayList<TransactionEntity> getByUserId(int id);
    ArrayList<TransactionEntity> getAll();
}
