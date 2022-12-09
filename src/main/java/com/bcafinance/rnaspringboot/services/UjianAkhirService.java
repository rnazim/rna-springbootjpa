package com.bcafinance.rnaspringboot.services;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 09/12/2022
@Last Modified 09/12/2022 13:39
Version 1.0
*/

import com.bcafinance.rnaspringboot.models.Regions;
import com.bcafinance.rnaspringboot.models.Student;
import com.bcafinance.rnaspringboot.models.UjianAkhir;
import com.bcafinance.rnaspringboot.repos.UjianAkhirRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UjianAkhirService {

    @Getter
    private UjianAkhirRepo ujianAkhirRepo;

    @Autowired
    public void setUjianAkhirRepo(UjianAkhirRepo ujianAkhirRepo) {
        this.ujianAkhirRepo = ujianAkhirRepo;
    }

    //CREATE QUERY
    @Transactional(rollbackFor = Exception.class)
    public void saveUjianAkhir(UjianAkhir ujianAkhir) throws Exception {
        ujianAkhirRepo.insertUjianAkhirQuery(ujianAkhir.getVar1(),ujianAkhir.getVar2(),ujianAkhir.getVar3());
    }

    //CREATE BATCH DEFAULT JPA
    @Transactional(rollbackFor = {Exception.class})
    public void saveAllUjianAkhir(List<UjianAkhir> ls){
        ujianAkhirRepo.saveAll(ls);
    }

    //GET DATA USING SIZE AND PAGE
    public Page<UjianAkhir> findAllUjianAkhir(Pageable pageable)
    {
        return ujianAkhirRepo.findAll(pageable);
    }
}
