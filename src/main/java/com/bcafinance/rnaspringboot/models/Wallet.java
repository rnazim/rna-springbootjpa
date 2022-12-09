package com.bcafinance.rnaspringboot.models;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 07/12/2022
@Last Modified 07/12/2022 10:52
Version 1.0
*/

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MstWallet")
public class Wallet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WalletID")
    private Long id;

    @Column(name = "noRekening", nullable = true)
    private String noRekening;

    @Column(name = "jumlahSaldo", nullable = true)
    private Double jumlahSaldo;

    @Column(name = "CreatedBy",nullable = true)
    private String createdBy = "1";

    @Column(name = "CreatedDate",nullable = true)
    private Date createdDate = new Date();

//    @Column(name = "JumlahTransfer", nullable = true)
//    private Integer jumlahTransfer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public Double getJumlahSaldo() {
        return jumlahSaldo;
    }

    public void setJumlahSaldo(Double jumlahSaldo) {
        this.jumlahSaldo = jumlahSaldo;
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
}
