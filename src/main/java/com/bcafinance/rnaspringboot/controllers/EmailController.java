package com.bcafinance.rnaspringboot.controllers;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 12/4/2022 6:42 PM
Last Modified on 12/4/2022 6:42 PM
Version 1.0
*/

import com.bcafinance.rnaspringboot.configuration.ConfigProperties;
import com.bcafinance.rnaspringboot.core.SMTPCore;
import com.bcafinance.rnaspringboot.handler.ResourceNotFoundException;
import com.bcafinance.rnaspringboot.handler.ResponseHandler;
import com.bcafinance.rnaspringboot.models.Email;
import com.bcafinance.rnaspringboot.services.EmailService;
import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1")
public class EmailController {

    @Getter
    private EmailService emailService;

    public EmailController(){
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public EmailController(EmailService emailService){
        this.emailService = emailService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object>
    saveEmails( @RequestBody Email email) throws Exception {
        if(email ==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        String[] strArr = new String[email.size()];
        strArr[0] = email.getEmail();
        String token = email.getEmail().substring(1,3)+email.getCreatedDate().toString().substring(1,5)+"123"+email.getUsername().substring(1,2);

        email.setToken(token);
        emailService.saveEmail(email);


        System.out.println(System.getProperty("user.dir"));
        SMTPCore sc = new SMTPCore();
        ConfigProperties.getEmailPassword();
        String s = "coba";
        System.out.println(sc.sendMailWithAttachment(strArr,
                "EMAIL AUTHENTICATION","TOKEN REGISTRATION : "+"http://localhost:8080/api/v1/a/"+token,
                "SSL",
                new String[] {ResourceUtils.getFile("classpath:\\data\\sample.docx").getAbsolutePath()}));


        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SEND_EMAIL, HttpStatus.CREATED,null,null,null);
    }
}
