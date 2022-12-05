package com.bcafinance.rnaspringboot.repos;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 12/4/2022 5:01 PM
Last Modified on 12/4/2022 5:01 PM
Version 1.0
*/

import com.bcafinance.rnaspringboot.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailRepo extends JpaRepository<Email, Long> {

    Optional<Email> findByEmail(String email);
}
