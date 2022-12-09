package com.bcafinance.rnaspringboot.repos;

import com.bcafinance.rnaspringboot.models.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction,Long> {
    List<Transaction> findBynameCustomerIsContaining(String name, Pageable pageable);

//    List<Cars> findByCarNameIsContaining(String name);
//
    List<Transaction> findTop3ByNameCustomerIsContaining(String name);
//
    List<Transaction> findByTotalItemIsGreaterThan(Integer totalItem);
//
    List<Transaction> findByNameCustomerIsContainingOrCostLike(String name, Double cost);
//
    List<Transaction> findByTotalItemIsContainingAndCostIsGreaterThan(Integer totalItem, Double cost);
}
