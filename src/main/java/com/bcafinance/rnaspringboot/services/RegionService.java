package com.bcafinance.rnaspringboot.services;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 01/12/2022
@Last Modified 01/12/2022 15:12
Version 1.0
*/

import com.bcafinance.rnaspringboot.models.Regions;
import com.bcafinance.rnaspringboot.repos.RegionRepo;
import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
