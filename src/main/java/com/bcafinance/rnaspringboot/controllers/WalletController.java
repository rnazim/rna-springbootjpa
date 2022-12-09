package com.bcafinance.rnaspringboot.controllers;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 07/12/2022
@Last Modified 07/12/2022 11:22
Version 1.0
*/

import com.bcafinance.rnaspringboot.dto.WalletDTO;
import com.bcafinance.rnaspringboot.handler.ResourceNotFoundException;
import com.bcafinance.rnaspringboot.handler.ResponseHandler;
import com.bcafinance.rnaspringboot.models.Foods;
import com.bcafinance.rnaspringboot.models.Wallet;
import com.bcafinance.rnaspringboot.services.WalletService;
import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class WalletController {
    @Getter
    private WalletService walletService;

    @Autowired
    private ModelMapper modelMapper;
    public WalletController() {
    }

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/wallet")
    public ResponseEntity<Object>
    saveWallet(@Valid @RequestBody Wallet wallet) throws Exception {

        if(wallet==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        walletService.saveWallet(wallet);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

    @PostMapping("/wallet/transfer")
    public ResponseEntity<Object>
    transferWallet(@Valid @RequestBody WalletDTO walletDTO) throws Exception {

        if(walletDTO==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        walletService.transferWallet(walletDTO);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_TRANSFER_WALLET, HttpStatus.CREATED,null,null,null);
    }
}
