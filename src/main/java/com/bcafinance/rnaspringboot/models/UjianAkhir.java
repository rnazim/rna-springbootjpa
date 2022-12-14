package com.bcafinance.rnaspringboot.models;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 09/12/2022
@Last Modified 09/12/2022 13:28
Version 1.0
*/

import com.bcafinance.rnaspringboot.utils.ConstantMessage;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "UjianAkhir")
public class UjianAkhir implements Serializable {

    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull(message = ConstantMessage.ERROR_TIDAK_BOLEH_KOSONG_VAR_1) //"VARIABEL 1 WAJIB DIISI" (PINDAHKAN PESAN KE ConstantMessage)
    @Column(name = "Var1" ,nullable = false)
    private Integer var1;

    @NotNull(message = ConstantMessage.ERROR_TIDAK_BOLEH_KOSONG_VAR_2)//"VARIABEL 2 WAJIB DIISI" (PINDAHKAN PESAN KE ConstantMessage)
    @Column(name = "Var2" ,nullable = false)
    private Double var2;

    @NotEmpty(message = ConstantMessage.ERROR_TIDAK_BOLEH_KOSONG_VAR_3)//"VARIABEL 3 WAJIB DIISI" (PINDAHKAN PESAN KE class ConstantMessage)
    @Column(name = "Var3",nullable = false)
    private String var3 ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVar1() {
        return var1;
    }

    public void setVar1(Integer var1) {
        this.var1 = var1;
    }

    public Double getVar2() {
        return var2;
    }

    public void setVar2(Double var2) {
        this.var2 = var2;
    }

    public String getVar3() {
        return var3;
    }

    public void setVar3(String var3) {
        this.var3 = var3;
    }
}

