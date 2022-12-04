package com.bcafinance.rnaspringboot.models;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 30/11/2022
@Last Modified 30/11/2022 14:10
Version 1.0
*/
import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "MstSuppliers")
public class Suppliers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SupplierID")
    private Long id;

    @NotEmpty(message = ConstantMessage.WARNING_EMAIL_MANDATORY)
    @Column(name = "EmailSupplier", length = 50, nullable = false, unique = true)
    private String emailSupplier;

    @NotEmpty(message = ConstantMessage.WARNING_PHONENUMBER_MANDATORY)
    @Column(name = "PhoneNumber", length = 16, nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "NameSupplier", length = 150, nullable = false)
    private String nameSupplier;

    @Column(name = "AddressSupplier", nullable = false)
    private String addressSupplier;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "CreatedBy", nullable = false)
    private String createdBy = "1";

    @Column(name = "CreatedDate", nullable = false)
    private Date createdDate = new Date();

    @Column(name = "ModifiedBy", nullable = true)
    private String modifiedBy;

    @Column(name = "ModifiedDate", nullable = true)
    private Date modifiedDate;

    @Column(name = "IsActive", nullable = false)
    private boolean isActive = true;

    public Suppliers() {
    }

    @ManyToOne
    private Regions regions;


    @ManyToMany(mappedBy = "suppliers")
    @JsonBackReference
    private Set<Foods> foodList = new HashSet<Foods>();

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

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getAddressSupplier() {
        return addressSupplier;
    }

    public void setAddressSupplier(String addressSupplier) {
        this.addressSupplier = addressSupplier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Regions getRegions() {
        return regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }

    public Set<Foods> getFoodList() {
        return foodList;
    }

    public void setFoodList(Set<Foods> foodList) {
        this.foodList = foodList;
    }
}
