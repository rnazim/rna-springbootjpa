package com.bcafinance.rnaspringboot.controllers;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 30/11/2022
@Last Modified 30/11/2022 14:29
Version 1.0
*/

import com.bcafinance.rnaspringboot.handler.ResourceNotFoundException;
import com.bcafinance.rnaspringboot.handler.ResponseHandler;
import com.bcafinance.rnaspringboot.models.Suppliers;
import com.bcafinance.rnaspringboot.services.SupplierService;
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
public class SupplierController {
    @Getter
    private SupplierService supplierService;


    public SupplierController() {
    }

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/suppliers")
    public ResponseEntity<Object>
    saveSuppliers(@Valid @RequestBody Suppliers suppliers) throws Exception {

        if(suppliers==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        supplierService.saveSuppliers(suppliers);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

    @PutMapping("/suppliers/u")
    public ResponseEntity<Object> updateSupplierByID(@RequestBody Suppliers suppliers)throws Exception{
        supplierService.updateSupplierById(suppliers);
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,"",null,null);
    }

//    @GetMapping("/v2/suppliers/{id}")
//    public ResponseEntity<Object> getSuppliersById(@PathVariable("id") long id) throws Exception {
//        Suppliers suppliers = supplierService.findByIdSuppliers(id);
//
//        if(suppliers != null)
//        {
//            return new ResponseHandler().
//                    generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,suppliers,null,null);
//        }
//        else
//        {
//            throw new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND);
//        }
//    }

    @GetMapping("/suppliers/datas/all/0")
    public ResponseEntity<Object> findAllSuplliers()throws Exception{

        int data = 0;
        List<Suppliers> lsSuppliers = supplierService.findAllSuppliers();

        if(lsSuppliers.size()==0)
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsSuppliers,null,null);
    }

    @GetMapping("/suppliers/datas/search/{nameSupplier}")
    public ResponseEntity<Object> getSupplierByNameSupplier(@PathVariable("nameSupplier") String nameSupplier)throws Exception{

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,supplierService.findByNameSupplier(nameSupplier),null,null);
    }

    @GetMapping("/suppliers/datas/notlike/{nameSupplier}")
    public ResponseEntity<Object> getSupplierByNameSupplierNotLike(@PathVariable("nameSupplier") String nameSupplier)throws Exception{

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,supplierService.findByNameSupplierNotLike(nameSupplier),null,null);
    }

    @GetMapping("/suppliers/datas/searchlike/{nameSupplier}")
    public ResponseEntity<Object> getSupplierByNameSupplierLike(@PathVariable("nameSupplier") String nameSupplier)throws Exception{

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,supplierService.findByNameSupplierLike(nameSupplier),null,null);
    }

    @PostMapping("/suppliers/bat")
    public ResponseEntity<Object>
    saveAllSuppliers(@RequestBody List<Suppliers> suppliers) throws Exception {

        if(suppliers==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        supplierService.saveAllSuppliers(suppliers);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }
}
