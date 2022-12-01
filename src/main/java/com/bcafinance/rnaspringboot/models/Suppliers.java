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
import lombok.Data;
import org.apache.logging.log4j.message.Message;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "MstSuppliers")
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SupplierID")
    private Long id;

    @Column(name = "EmailSupplier", length = 50, nullable = false, unique = true)
    private String emailSupplier;

    @Column(name = "PhoneNumber", length = 16, nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "NameSupplier", length = 150, nullable = false)
    private String nameSupplier;

    @Column(name = "AddressSupplier", nullable = false)
    private String addressSupplier;

    @Column(name = "Products", nullable = false)
    private String products;

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

}
