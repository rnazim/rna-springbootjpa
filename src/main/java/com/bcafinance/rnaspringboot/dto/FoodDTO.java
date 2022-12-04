package com.bcafinance.rnaspringboot.dto;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 03/12/2022
@Last Modified 03/12/2022 16:38
Version 1.0
*/

import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodDTO {
    private Long id;

    private String nameFood;

    private String description;

    private double priceFood;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(double priceFood) {
        this.priceFood = priceFood;
    }
}
