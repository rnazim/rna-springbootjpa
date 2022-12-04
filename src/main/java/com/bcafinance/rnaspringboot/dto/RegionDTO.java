package com.bcafinance.rnaspringboot.dto;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 02/12/2022
@Last Modified 02/12/2022 9:52
Version 1.0
*/

import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegionDTO {

    private Long id;


    private String kodeRegion;

    @Email(message = ConstantMessage.ERROR_EMAIL_FORMAT_INVALID)
    @Length(max = 50 , message = ConstantMessage.WARNING_REGION_NAME_LENGTH)
//    @NotEmpty(message = ConstantMessage.WARNING_DIVISION_NAME_MANDATORY)
    private String nameRegion;


//    @NotEmpty(message = ConstantMessage.WARNING_DIVISION_DESC_MANDATORY)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String getKodeRegion() { return  kodeRegion; }

    public void setKodeRegion(String kodeRegion) { this.kodeRegion = kodeRegion; }

    public String getNameRegion() {
        return nameRegion;
    }

    public void setNameRegion(String nameRegion) {
        this.nameRegion = nameRegion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
