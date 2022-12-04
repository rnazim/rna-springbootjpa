//package com.bcafinance.rnaspringboot.models;/*
//Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
//Build #IU-222.4345.14, built on October 5, 2022
//@Author Azim a.k.a. Azim
//Java Developer
//Create on 02/12/2022
//@Last Modified 02/12/2022 18:49
//Version 1.0
//*/
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Date;
//
//@Data
//@Entity
//@Table(name = "FoodSupplier")
//public class Orders implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "FoodSupplierID")
//    private Long id;
//
//    @Column(name = "FoodID", nullable = false)
//    private Date foodId;
//
//    @Column(name = "SupplierID",length = 255,nullable = false)
//    private String supplierID;
//
//    @Column(name = "CreatedBy",nullable = false)
//    private String createdBy = "1";
//
//    @Column(name = "CreatedDate",nullable = false)
//    private Date createdDate = new Date();
//
//    @Column(name = "ModifiedBy",nullable = true)
//    private String modifiedBy ;
//
//    @Column(name = "ModifiedDate",nullable = true)
//    private Date modifiedDate;
//
//    @Column(name = "IsActive",nullable = false)
//    private boolean isActive = true;
//
//    public Orders() {
//    }
//
//}
