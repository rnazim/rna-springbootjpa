//package com.bcafinance.rnaspringboot.controllers;/*
//Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
//Build #IU-222.4345.14, built on October 5, 2022
//@Author Azim a.k.a. Azim
//Java Developer
//Create on 02/12/2022
//@Last Modified 02/12/2022 20:15
//Version 1.0
//*/
//
//import com.bcafinance.rnaspringboot.handler.ResourceNotFoundException;
//import com.bcafinance.rnaspringboot.handler.ResponseHandler;
//import com.bcafinance.rnaspringboot.models.Orders;
//import com.bcafinance.rnaspringboot.services.OrderService;
//import com.bcafinance.rnaspringboot.utils.ConstantMessage;
//import lombok.Getter;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Collection;
//
//@RestController
//@RequestMapping("api/v1")
//public class OrderController {
//    @Getter
//    private OrderService orderService;
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public OrderController() {
//    }
//
//    @Autowired
//    public OrderController(OrderService orderService) {
//        this.orderService = orderService;
//    }
//    @GetMapping("/foodsuppliers/datas/all/0")
//    public ResponseEntity<Object> findAllFoodSupplier()throws Exception{
//
//        int data = 0;
//        Iterable<Orders> lsFoodSupplier = orderService.findAllFoodSuppliers();
//
//        if(lsFoodSupplier instanceof Collection<Orders>)
//        {
//            data = ((Collection<Orders>) lsFoodSupplier).size();
//        }
//        if(data==0)
//        {
//            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
//        }
//
//        return new ResponseHandler().
//                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,lsFoodSupplier,null,null);
//    }
//
//}
