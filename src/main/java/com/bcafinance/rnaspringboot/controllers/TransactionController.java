package com.bcafinance.rnaspringboot.controllers;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 06/12/2022
@Last Modified 06/12/2022 11:39
Version 1.0
*/

import com.bcafinance.rnaspringboot.dto.StudentDTO;
import com.bcafinance.rnaspringboot.dto.TransactionDTO;
import com.bcafinance.rnaspringboot.handler.ResourceNotFoundException;
import com.bcafinance.rnaspringboot.handler.ResponseHandler;
import com.bcafinance.rnaspringboot.models.Transaction;
import com.bcafinance.rnaspringboot.services.TransactionService;
import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import com.bcafinance.rnaspringboot.utils.CsvReader;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/")
public class TransactionController {
    @Getter
    private TransactionService transactionService;
    @Autowired
    private ModelMapper modelMapper;

    private List<Transaction> lsTransaction = new ArrayList<Transaction>();

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/v1/transaction/upl/bat/11")
    public ResponseEntity<Object>
    uploadTransaction(@Valid @RequestParam("demoFile") MultipartFile multipartFile) throws Exception {
        try {
            if (CsvReader.isCsv(multipartFile)) {
                transactionService.saveBulkTransaction(multipartFile);
            } else {
                throw new ResourceNotFoundException(ConstantMessage.ERROR_NOT_CSV_FILE + " -- " + multipartFile.getOriginalFilename());
            }
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR_UPLOAD_CSV + multipartFile.getOriginalFilename());
        }
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE,
                HttpStatus.CREATED, null, null, null);
    }

    @GetMapping("/v1/transaction/datas/all/dto/9")
    public ResponseEntity<Object> findAllTransactionDTO() throws Exception {

        List<Transaction> lsTransaction = transactionService.findAllTransaction();

        if (lsTransaction.size() != 0) {
            List<TransactionDTO> lsTransactionDTO = modelMapper.map(lsTransaction, new TypeToken<List<TransactionDTO>>() {
            }.getType());

            return new ResponseHandler().
                    generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK, lsTransactionDTO, null, null);
        }
        throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
    }

    @GetMapping("/v1/transaction/search/dto/{size}/{page}")
    public ResponseEntity<Object> pageFindTransactionByNameDTO(@RequestParam String name,
                                                           @PathVariable("size") int size,
                                                           @PathVariable("page") int page) throws Exception {

        Pageable pageable = PageRequest.of(page,size);
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,transactionService.pagingFindTransactionByName(name, pageable),null,null);
    }

    @GetMapping("/v1/transaction/search/dto/{size}/{page}/{sort}")
    public ResponseEntity<Object> pageSortByName(@RequestParam String name,
                                                    @PathVariable("size") int size,
                                                    @PathVariable("page") int page,
                                                    @PathVariable("sort") String sortz)throws Exception {

        Pageable pageable;
        if(sortz.equalsIgnoreCase("desc"))
        {
            pageable = PageRequest.of(page,size, Sort.by("nameCustomer").descending());
        }
        else
        {
            pageable = PageRequest.of(page,size, Sort.by("nameCustomer"));//default asc
        }

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,transactionService.pagingFindTransactionByName(name,pageable),null,null);
    }

//    @GetMapping("/v1/transaction/search/top3/{name}")
//    public Transaction findTop3ByName(String name) throws Exception
//    {
//        return transactionService.findTop3TransactionByName(name).orElseThrow(()->
//                new ResourceNotFoundException(ConstantMessage.WARNING_SUPPLIER_DATA_NOT_FOUND));
//    }

    @GetMapping("/v1/transaction/find3Top")
    public ResponseEntity<Object> findTop3ByNameCustomer(@RequestParam String name) throws Exception {

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,transactionService.findTop3TransactionByNameCustomer(name),null,null);
    }

    @GetMapping("/v1/transaction/findByCostIsGreaterThan")
    public ResponseEntity<Object> findByCostIsGreaterThan(@RequestParam Integer totalitem) throws Exception {

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,transactionService.findByTotalItemIsGreaterThan(totalitem),null,null);
    }

    @GetMapping("/v1/transaction/findOR")
    public ResponseEntity<Object> findByNameCustomerIsContainingOrPayDateLike(@RequestParam String name,
                                                                                @RequestParam Double cost
                                                                                ) throws Exception {

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,transactionService.findByByNameCustomerIsContainingOrCostLike(name, cost),null,null);
    }

    @GetMapping("/v1/transaction/findORisGreaterThan")
    public ResponseEntity<Object> findByTotalItemIsContainingAndCostIsGreaterThan(@RequestParam Integer totalItem,
                                                                                @RequestParam Double cost
    ) throws Exception {

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,transactionService.findByTotalItemIsContainingAndCostIsGreaterThan(totalItem, cost),null,null);
    }
}
