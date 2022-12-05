package com.bcafinance.rnaspringboot.services;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 12/4/2022 5:08 PM
Last Modified on 12/4/2022 5:08 PM
Version 1.0
*/


import com.bcafinance.rnaspringboot.handler.ResourceNotFoundException;
import com.bcafinance.rnaspringboot.models.Email;
import com.bcafinance.rnaspringboot.repos.EmailRepo;
import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class EmailService {

    @Autowired
    private EmailRepo emailRepo;


//    @Autowired
//    EmailService(EmailRepo emailRepo){this.emailRepo = emailRepo;}

//    @Autowired
//    EmailService(TokenRepo tokenRepo) { this.tokenRepo = tokenRepo; }

    public void saveEmail(Email email) throws Exception{
        if(email.getEmail()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);

        Optional<Email> getEmail = emailRepo.findByEmail(email.getEmail());
        if(getEmail.isPresent())
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_EMAIL_EXIST);
        }
        emailRepo.save(email);
    }
}
