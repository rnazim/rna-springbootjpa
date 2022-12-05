package com.bcafinance.rnaspringboot.models;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 01/12/2022
@Last Modified 01/12/2022 15:11
Version 1.0
*/

import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Entity
@Table(name = "MstRegions")
public class Regions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RegionID")
    private Long id;

    @NotEmpty(message = ConstantMessage.WARNING_KODEGROUP_MANDATORY)
    @Column(name = "KodeRegion", length = 50, nullable = false, unique = true)
    private String kodeRegion;

    @NotEmpty(message = ConstantMessage.WARNING_WILAYAHREGION_MANDATORY)
    @Column(name = "NameRegion", nullable = false, unique = true)
    private String nameRegion;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKodeRegion() {
        return kodeRegion;
    }

    public void setKodeRegion(String kodeRegion) {
        this.kodeRegion = kodeRegion;
    }

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
}
