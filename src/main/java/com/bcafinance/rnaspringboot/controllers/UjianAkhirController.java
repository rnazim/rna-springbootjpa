package com.bcafinance.rnaspringboot.controllers;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 09/12/2022
@Last Modified 09/12/2022 13:38
Version 1.0
*/

import com.bcafinance.rnaspringboot.handler.ResourceNotFoundException;
import com.bcafinance.rnaspringboot.handler.ResponseHandler;
import com.bcafinance.rnaspringboot.models.Regions;
import com.bcafinance.rnaspringboot.models.UjianAkhir;
import com.bcafinance.rnaspringboot.models.Wallet;
import com.bcafinance.rnaspringboot.services.UjianAkhirService;
import com.bcafinance.rnaspringboot.services.WalletService;
import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UjianAkhirController {
    @Getter
    private UjianAkhirService ujianAkhirService;

    @Autowired
    private ModelMapper modelMapper;
    public UjianAkhirController() {
    }

    @Autowired
    public UjianAkhirController(UjianAkhirService ujianAkhirService) {
        this.ujianAkhirService = ujianAkhirService;
    }

    //CREATE QUERY
    @PostMapping("/ujianAkhir")
    public ResponseEntity<Object>
    saveUjianAkhir(@Valid @RequestBody UjianAkhir ujianAkhir) throws Exception {

        if(ujianAkhir==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        ujianAkhirService.saveUjianAkhir(ujianAkhir);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

    //CREATE BATCH DATA DEFAULT JPA
    @PostMapping("/ujianAkhir/bat")
    public ResponseEntity<Object>
    saveAllUjianAkhir(@RequestBody List<UjianAkhir> ujianAkhir) throws Exception {

        if(ujianAkhir==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        ujianAkhirService.saveAllUjianAkhir(ujianAkhir);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

    //GET DATA USING SIZE AND PAGE
    @GetMapping("/ujianAkhir/search/{size}/{page}")
    public ResponseEntity<Object> pageFindUjianAkhir(@PathVariable("size") int size,
                                                           @PathVariable("page") int page) throws Exception {


        Pageable pageable = PageRequest.of(page, size);
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK, ujianAkhirService.findAllUjianAkhir(pageable), null, null);
    }
}
