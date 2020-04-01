package com.snezhko.service.impl;

import com.snezhko.entity.TransactionEntity;
import com.snezhko.entity.UserEntity;
import com.snezhko.repository.TransactionRepo;
import com.snezhko.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("TransactionServiceImpl")
@Repository
@Transactional
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepo transactionRepo;

    @Autowired
    public TransactionServiceImpl(TransactionRepo transactionRepo){
        this.transactionRepo = transactionRepo;
    }


    @Override
    public void save(TransactionEntity transactionEntity) {
        transactionRepo.save(transactionEntity);
    }

    @Override
    public ArrayList<TransactionEntity> getByUserId(int id) {
        ArrayList<TransactionEntity> list = new ArrayList<TransactionEntity>();
        ArrayList<TransactionEntity> find = (ArrayList<TransactionEntity>) transactionRepo.findAll();
        for(TransactionEntity entity : find){
            if(entity.getUserId()==id){
                list.add(entity);
            }
        }
        return list;
    }

    @Override
    public ArrayList<TransactionEntity> getAll() {

            return (ArrayList<TransactionEntity>) transactionRepo.findAll();
    }
}
