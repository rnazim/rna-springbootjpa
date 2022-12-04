package com.bcafinance.rnaspringboot.controllers;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 03/12/2022
@Last Modified 03/12/2022 12:29
Version 1.0
*/

import com.bcafinance.rnaspringboot.handler.ResourceNotFoundException;
import com.bcafinance.rnaspringboot.handler.ResponseHandler;
import com.bcafinance.rnaspringboot.models.Foods;
import com.bcafinance.rnaspringboot.models.Products;
import com.bcafinance.rnaspringboot.models.Suppliers;
import com.bcafinance.rnaspringboot.services.FoodService;
import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class FoodController {


    @Getter
    private FoodService foodService;

    public FoodController() {
    }


    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/foods")
    public ResponseEntity<Object>
    saveFood(@Valid @RequestBody Foods foods,
                @RequestHeader Map<String,String> headers,
                @RequestParam Map<String,String> params,
                WebRequest request, Error error) throws Exception {
        foodService.saveFood(foods);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE,HttpStatus.CREATED,null,null,null);
    }

    @PostMapping("/foods/bat")
    public ResponseEntity<Object>
    saveAllFoods(@RequestBody List<Foods> foods) throws Exception {

        if(foods==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        foodService.saveAllFoods(foods);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

    @PutMapping("/foods/u")
    public ResponseEntity<Object> updateFoodByID(@RequestBody Foods foods)throws Exception{
        foodService.updateFoods(foods);
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,"",null,null);
    }

    @GetMapping("/foods/datas/all/0")
    public ResponseEntity<Object> findAllFoods()throws Exception{

        int data = 0;
        List<Foods> lsFoods = foodService.findAllFoods();

        if(lsFoods.size()==0)
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsFoods,null,null);
    }


    @GetMapping("/foods/{id}")
    public ResponseEntity<Object> getFoodById(@PathVariable("id") long id) throws Exception {
        Foods foods = foodService.findByIdFood(id);

        if(foods != null)
        {
            return new ResponseHandler().
                    generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,foods,null,null);
        }
        else
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND);
        }
    }

    @PostMapping("/foods/supplier/{id}")
    public ResponseEntity<Object> addSupplier(@RequestBody Suppliers suppliers, @PathVariable("id") Long foodId) throws Exception {
        foodService.addSupplier(suppliers,foodId);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

}
