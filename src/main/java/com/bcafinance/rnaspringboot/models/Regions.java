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

//    @NotEmpty(message = ConstantMessage.WARNING_KODEGROUP_MANDATORY)
    @Column(name = "KodeRegion", length = 50, nullable = false, unique = true)
    private String kodeRegion;

//    @NotEmpty(message = ConstantMessage.WARNING_WILAYAHREGION_MANDATORY)
    @Column(name = "NameRegion", length = 16, nullable = false, unique = true)
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

    public Regions() {
    }
}
