package com.bcafinance.rnaspringboot.models;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 06/12/2022
@Last Modified 06/12/2022 10:38
Version 1.0
*/

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "MstTransactions")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionID")
    private Long id;

    @Column(name = "NameCustomer", length = 150, nullable = false)
    private String nameCustomer;

    @Column(name = "AgeCustomer",nullable = false)
    private Integer ageCustomer;

    @Column(name = "AddressCustomer", nullable = false)
    private String addressCustomer;

    @Column(name = "TotalItem",nullable = false)
    private Integer totalItem;
    @Column(name = "Cost",nullable = false)
    private Double cost;

    @Column(name = "Cashback",nullable = false)
    private Double cashback;

    @Column(name = "BillDate",nullable = true)
    private LocalDate billDate;

    @Column(name = "PayDate",nullable = true)
    private LocalDate payDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Integer getAgeCustomer() {
        return ageCustomer;
    }

    public void setAgeCustomer(Integer ageCustomer) {
        this.ageCustomer = ageCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getCashback() {
        return cashback;
    }

    public void setCashback(Double cashback) {
        this.cashback = cashback;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }
}
