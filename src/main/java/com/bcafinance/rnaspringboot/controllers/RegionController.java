package com.bcafinance.rnaspringboot.controllers;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 01/12/2022
@Last Modified 01/12/2022 15:11
Version 1.0
*/

import com.bcafinance.rnaspringboot.handler.ResourceNotFoundException;
import com.bcafinance.rnaspringboot.handler.ResponseHandler;
import com.bcafinance.rnaspringboot.models.Regions;
import com.bcafinance.rnaspringboot.services.RegionService;
import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class RegionController {
    @Getter
    private RegionService regionService;


    public RegionController() {
    }

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @PostMapping("/regions")
    public ResponseEntity<Object>
    saveRegions(@Valid @RequestBody Regions regions) throws Exception {

        if (regions == null) throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        regionService.saveRegions(regions);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED, null, null, null);
    }

    @GetMapping("/regions/datas/all/0")
    public ResponseEntity<Object> findAllRegions()throws Exception{

        int data = 0;
        List<Regions> lsRegions = regionService.findAllRegions();

        if(lsRegions.size()==0)
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsRegions,null,null);
    }
}