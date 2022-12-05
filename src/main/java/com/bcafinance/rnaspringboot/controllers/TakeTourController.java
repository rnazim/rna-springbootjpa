package com.bcafinance.rnaspringboot.controllers;


import com.bcafinance.rnaspringboot.configuration.ConfigProperties;
import com.bcafinance.rnaspringboot.core.SMTPCore;
import com.bcafinance.rnaspringboot.handler.ResponseHandler;
import com.bcafinance.rnaspringboot.models.Email;
import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import com.bcafinance.rnaspringboot.utils.ReadTextFileSB;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TakeTourController {

    @GetMapping("/welcome")
    public String getTakeTour(){
        return ConstantMessage.WELCOME_MESSAGE;
    }

    @PostMapping("/readytostart")
    public String postTakeTour(){
        return ConstantMessage.TAKE_TOUR;
    }

    @PostMapping("/runnerz")
    public ResponseEntity<Object> executionClass(@RequestBody List<Email> lsEmail) throws Exception {
        String[] strArr = new String[lsEmail.size()];

        for(int i=0;i<strArr.length;i++)
        {
            strArr[i] = lsEmail.get(i).getEmail();
            System.out.println("EMAIL KE - "+i+" : "+lsEmail.get(i));
        }
        System.out.println(System.getProperty("user.dir"));
        SMTPCore sc = new SMTPCore();
        ConfigProperties.getEmailPassword();
        System.out.println(sc.sendMailWithAttachment(strArr,
                "INI HANYA TEST",new ReadTextFileSB("\\data\\template-BCAF.html").getContentFile(),
                "SSL",
                new String[] {ResourceUtils.getFile("classpath:\\data\\sample.docx").getAbsolutePath()}));
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SEND_EMAIL, HttpStatus.CREATED,null,null,null);
    }
}
