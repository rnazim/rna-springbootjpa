package com.bcafinance.rnaspringboot.services;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 03/12/2022
@Last Modified 03/12/2022 12:27
Version 1.0
*/

import com.bcafinance.rnaspringboot.handler.ResourceNotFoundException;
import com.bcafinance.rnaspringboot.models.Foods;
import com.bcafinance.rnaspringboot.models.Products;
import com.bcafinance.rnaspringboot.models.Regions;
import com.bcafinance.rnaspringboot.models.Suppliers;
import com.bcafinance.rnaspringboot.repos.FoodRepo;
import com.bcafinance.rnaspringboot.repos.ProductRepo;
import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class FoodService {

    @Getter
    private FoodRepo foodRepo;

    @Autowired
    public void setFoodRepo(FoodRepo foodRepo) {
        this.foodRepo = foodRepo;
    }

    public void saveFood(Foods foods) throws Exception {
        if (foods.getNameFood() == null) throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if (foods.getDescription() == null) throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);

        foodRepo.save(foods);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveAllFoods(List<Foods> ls){
        foodRepo.saveAll(ls);
    }

    @Transactional
    public void updateFoods(Foods p) throws Exception{

        Foods foods = foodRepo.findById(p.getId()).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_PRODUCT_NOT_FOUND));

        foods.setModifiedBy("1");
        foods.setModifiedDate(new Date());
        if(p.getNameFood() != null && !Objects.equals(foods.getNameFood(),p.getNameFood()) && !p.getNameFood().equals(""))
        {
            foods.setNameFood(p.getNameFood());
        }

        if(p.getDescription() != null && !Objects.equals(foods.getDescription(),p.getDescription()) && !p.getDescription().equals(""))
        {
            foods.setDescription(p.getDescription());
        }

        if(!(p.getPriceFood()<=((1.0/2) * foods.getPriceFood())) && p.getPriceFood()!=0 && !(p.getPriceFood()>(3*foods.getPriceFood())))
        {
            foods.setPriceFood(p.getPriceFood());
        }
        else
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_PRODUCT_PRICE_SOP);
        }

    }

    public void addSupplier(Suppliers suppliers, Long foodId) throws Exception {
        Foods foods = foodRepo.findById(foodId).
                orElseThrow(() -> new ResourceNotFoundException(ConstantMessage.WARNING_PRODUCT_NOT_FOUND));
        foods.getSuppliers().add(suppliers);
        saveFood(foods);
    }

    public Foods findByIdFood(Long id) throws Exception
    {
//        int intK = 5/0;
        return foodRepo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(ConstantMessage.WARNING_FOOD_DATA_NOT_FOUND));
    }
    public List<Foods> findAllFoods()throws Exception{
        return foodRepo.findAll();
    }

    public Foods findByNameFood(String nameFood) throws Exception
    {
        return foodRepo.findByNameFood(nameFood).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_FOOD_DATA_NOT_FOUND));
    }
}