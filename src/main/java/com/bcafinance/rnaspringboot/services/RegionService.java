package com.bcafinance.rnaspringboot.services;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 01/12/2022
@Last Modified 01/12/2022 15:12
Version 1.0
*/

import com.bcafinance.rnaspringboot.handler.FormatValidation;
import com.bcafinance.rnaspringboot.handler.ResourceNotFoundException;
import com.bcafinance.rnaspringboot.models.Regions;
import com.bcafinance.rnaspringboot.models.Suppliers;
import com.bcafinance.rnaspringboot.repos.RegionRepo;
import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class RegionService {
    private RegionRepo regionRepo;

    @Autowired
    public RegionService(RegionRepo regionRepo) {
        this.regionRepo = regionRepo;
    }

    public List<Regions> findAllRegions()
    {
        return regionRepo.findAll();
    }

    public void saveRegions(Regions regions) throws Exception
    {
        if(regions.getKodeRegion()=="" || regions.getKodeRegion()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(regions.getNameRegion()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(regions.getDescription()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);

        regionRepo.save(regions);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveAllRegions(List<Regions> ls){
        regionRepo.saveAll(ls);
    }

    @Transactional(rollbackFor = {Exception.class, SQLException.class})
    public void updateRegionById(Regions c) throws Exception {

        Regions regions = regionRepo.findById(c.getId()).orElseThrow(() ->
                new ResourceNotFoundException(ConstantMessage.WARNING_DATA_NOT_FOUND));

        regions.setModifiedBy("1");
        regions.setModifiedDate(new Date());


        if (c.getKodeRegion() != null
                && !Objects.equals(regions.getKodeRegion(), c.getKodeRegion())
                && !c.getKodeRegion().equals("")) {
            regions.setKodeRegion(c.getKodeRegion());
        }

        if (c.getNameRegion() != null
                && !Objects.equals(regions.getNameRegion(), c.getNameRegion())
                && !c.getNameRegion().equals("")) {
            regions.setNameRegion(c.getNameRegion());
        }

        if (c.getDescription() != null
                && !Objects.equals(regions.getDescription(), c.getDescription())
                && !c.getDescription().equals("")) {
            regions.setDescription(c.getDescription());
        }
    }

    public Regions findByIdRegions(Long id) throws Exception
    {
        return regionRepo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));
    }

    public Regions findByNameRegion(String nameRegion) throws Exception
    {
        return regionRepo.findByNameRegion(nameRegion).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_SUPPLIER_DATA_NOT_FOUND));
    }
}
