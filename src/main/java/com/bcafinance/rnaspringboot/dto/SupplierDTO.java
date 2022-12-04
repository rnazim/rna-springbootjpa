package com.bcafinance.rnaspringboot.dto;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 02/12/2022
@Last Modified 02/12/2022 11:13
Version 1.0
*/

import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplierDTO {
    private Long id;
    private String emailSupplier;
    private String phoneNumber;
    private String addressSupplier;
    private String regions;

    @Email(message = ConstantMessage.ERROR_EMAIL_FORMAT_INVALID)
    @Length(max = 100 , message = ConstantMessage.WARNING_REGION_NAME_LENGTH)
    @NotEmpty(message = ConstantMessage.WARNING_SUPPLIER_NOT_FOUND)
    private String nameSupplier;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailSupplier() {
        return emailSupplier;
    }

    public void setEmailSupplier(String emailSupplier) {
        this.emailSupplier = emailSupplier;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressSupplier() {
        return addressSupplier;
    }

    public void setAddressSupplier(String addressSupplier) {
        this.addressSupplier = addressSupplier;
    }

    public String getRegions() {
        return regions;
    }

    public void setRegions(String regions) {
        this.regions = regions;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
