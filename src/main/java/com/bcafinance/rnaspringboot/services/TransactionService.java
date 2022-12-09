package com.bcafinance.rnaspringboot.services;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 06/12/2022
@Last Modified 06/12/2022 10:51
Version 1.0
*/

import com.bcafinance.rnaspringboot.models.Student;
import com.bcafinance.rnaspringboot.models.Transaction;
import com.bcafinance.rnaspringboot.repos.TransactionRepo;
import com.bcafinance.rnaspringboot.utils.CsvReader;
import lombok.Getter;
import org.hibernate.hql.internal.classic.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TransactionService {
    @Getter
    private TransactionRepo transactionRepo;

    @Autowired
    public TransactionService(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Transaction> saveBulkTransaction(MultipartFile multipartFile) throws Exception
    {
        try{
            List<Transaction> lsTransaction = CsvReader.csvTransactionData(multipartFile.getInputStream());
            return transactionRepo.saveAll(lsTransaction);
        }catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }

    public List<Transaction> findAllTransaction()
    {
        return (List<Transaction>) transactionRepo.findAll();
    }

    public List<Transaction> pagingFindTransactionByName(String name, Pageable pageable)
    {
        return transactionRepo.findBynameCustomerIsContaining(name, pageable);
    }

    public List<Transaction> findTop3TransactionByNameCustomer(String name)
    {
        return transactionRepo.findTop3ByNameCustomerIsContaining(name);
    }

    public List<Transaction> findByTotalItemIsGreaterThan(Integer totalItem)
    {
        return transactionRepo.findByTotalItemIsGreaterThan(totalItem);
    }

    public List<Transaction> findByByNameCustomerIsContainingOrCostLike(String name, Double cost)
    {
        return transactionRepo.findByNameCustomerIsContainingOrCostLike(name, cost);
    }

    public List<Transaction> findByTotalItemIsContainingAndCostIsGreaterThan(Integer totalItem, Double cost)
    {
        return transactionRepo.findByTotalItemIsContainingAndCostIsGreaterThan(totalItem, cost);
    }
}
