//package com.bcafinance.rnaspringboot.services;/*
//Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
//Build #IU-222.4345.14, built on October 5, 2022
//@Author Azim a.k.a. Azim
//Java Developer
//Create on 02/12/2022
//@Last Modified 02/12/2022 20:13
//Version 1.0
//*/
//
//import com.bcafinance.rnaspringboot.models.Orders;
//import com.bcafinance.rnaspringboot.repos.OrderRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@Transactional
//public class OrderService {
//    private OrderRepo orderRepo;
//
//    @Autowired
//    public OrderService(OrderRepo orderRepo) {
//        this.orderRepo = orderRepo;
//    }
//
//    public List<Orders> findAllRegions()
//    {
//        return orderRepo.findAll();
//    }
//
//    @Transactional(rollbackFor = {Exception.class})
//    public void saveAllOrders(List<Orders> ls){
//        orderRepo.saveAll(ls);
//    }
//
//    public Iterable<Orders> findAllFoodSuppliers()throws Exception{
//        return orderRepo.findAll();
//    }
//}
