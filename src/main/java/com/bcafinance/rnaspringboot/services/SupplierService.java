package com.bcafinance.rnaspringboot.services;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 30/11/2022
@Last Modified 30/11/2022 14:20
Version 1.0
*/

import com.bcafinance.rnaspringboot.handler.FormatValidation;
import com.bcafinance.rnaspringboot.handler.ResourceNotFoundException;
import com.bcafinance.rnaspringboot.models.Products;
import com.bcafinance.rnaspringboot.models.Suppliers;
import com.bcafinance.rnaspringboot.repos.SupplierRepo;
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
public class SupplierService {
    private SupplierRepo supplierRepo;

    @Autowired
    public SupplierService(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

//    public List<Suppliers> findAllSuppliers()
//    {
//        return supplierRepo.findAll();
//    }

    public List<Suppliers> findAllSuppliers() {
        return supplierRepo.findAll();
    }


//    public Suppliers findByIdSuppliers(Long id) throws Exception
//    {
//        return supplierRepo.findById(id).
//                orElseThrow(() -> new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));
//    }

    public void saveSuppliers(Suppliers suppliers) throws Exception
    {
        if(suppliers.getEmailSupplier()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(suppliers.getNameSupplier()=="" || suppliers.getNameSupplier()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(suppliers.getPhoneNumber()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(suppliers.getDescription()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);

        FormatValidation.phoneNumberFormatValidation(suppliers.getPhoneNumber());
        FormatValidation.emailFormatValidation(suppliers.getEmailSupplier());

//        Supplier
        Optional<Suppliers> supByEmail = supplierRepo.findByEmailSupplier(suppliers.getEmailSupplier());
        if(supByEmail.isPresent())
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_EMAIL_EXIST);
        }
        supplierRepo.save(suppliers);
    }

    @Transactional(rollbackFor = {Exception.class, SQLException.class})
    public void updateSupplierById(Suppliers c) throws Exception {

        Suppliers suppliers = supplierRepo.findById(c.getId()).orElseThrow(() ->
                new ResourceNotFoundException(ConstantMessage.WARNING_SUPPLIER_DATA_NOT_FOUND));

        suppliers.setModifiedBy("1");
        suppliers.setModifiedDate(new Date());

        if (c.getNameSupplier() != null
                && !Objects.equals(suppliers.getNameSupplier(), c.getNameSupplier())
                && !c.getNameSupplier().equals("")) {
            suppliers.setNameSupplier(c.getNameSupplier());
        }

        if (c.getEmailSupplier() != null &&
                c.getEmailSupplier().length() > 0 &&
                !Objects.equals(suppliers.getEmailSupplier(), c.getEmailSupplier())) {
            FormatValidation.emailFormatValidation(c.getEmailSupplier());

            Optional<Suppliers> cBeanOptional = supplierRepo.findByEmailSupplier(c.getEmailSupplier());
            if (cBeanOptional.isPresent())//it means if exists
            {
                throw new ResourceNotFoundException(ConstantMessage.WARNING_EMAIL_EXIST);
            }
            suppliers.setEmailSupplier(c.getEmailSupplier());
        }

        if (c.getAddressSupplier() != null
                && !Objects.equals(suppliers.getAddressSupplier(), c.getAddressSupplier())
                && !c.getAddressSupplier().equals("")) {
            suppliers.setAddressSupplier(c.getAddressSupplier());
        }

        if (c.getPhoneNumber() != null &&
                c.getPhoneNumber().length() > 0 &&
                !Objects.equals(suppliers.getPhoneNumber(), c.getPhoneNumber())) {

            FormatValidation.phoneNumberFormatValidation(c.getPhoneNumber());
            suppliers.setPhoneNumber(c.getPhoneNumber());
        }

        if (c.getDescription() != null &&
                c.getDescription().length() > 0 &&
                !Objects.equals(suppliers.getDescription(), c.getDescription())) {

            suppliers.setDescription(c.getDescription());
        }
    }

        public Suppliers findByNameSupplier(String nameSupplier) throws Exception
        {
            List<Suppliers> lsTest = supplierRepo.searchByNameSupplierStartsWith(nameSupplier);
            for(int i=0;i<lsTest.size();i++)
            {
                System.out.println(lsTest.get(i).getNameSupplier());
                System.out.println(lsTest.get(i).getId());
                System.out.println(lsTest.get(i).getEmailSupplier());
                System.out.println(lsTest.get(i).getAddressSupplier());
                System.out.println(lsTest.get(i).getPhoneNumber());
                System.out.println(lsTest.get(i).getDescription());
                System.out.println();

            }
            return supplierRepo.findByNameSupplier(nameSupplier).orElseThrow(()->
                    new ResourceNotFoundException(ConstantMessage.WARNING_SUPPLIER_DATA_NOT_FOUND));
        }

    public Suppliers findByNameSupplierLike(String nameSupplier) throws Exception
    {
        return supplierRepo.findByNameSupplierLike(nameSupplier).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_SUPPLIER_DATA_NOT_FOUND));
    }
    public List<Suppliers> findByNameSupplierNotLike(String nameSupplier) throws Exception
    {
        return supplierRepo.findByNameSupplierNotLike(nameSupplier);
    }

    public Suppliers findByIdSuppliers(Long id) throws Exception
    {
        return supplierRepo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveAllSuppliers(List<Suppliers> ls){
        supplierRepo.saveAll(ls);
    }
}

