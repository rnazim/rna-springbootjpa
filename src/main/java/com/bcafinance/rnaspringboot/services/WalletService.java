package com.bcafinance.rnaspringboot.services;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 07/12/2022
@Last Modified 07/12/2022 11:16
Version 1.0
*/

import com.bcafinance.rnaspringboot.dto.WalletDTO;
import com.bcafinance.rnaspringboot.handler.ResourceNotFoundException;
import com.bcafinance.rnaspringboot.models.Student;
import com.bcafinance.rnaspringboot.models.Wallet;
import com.bcafinance.rnaspringboot.repos.WalletRepo;
import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class WalletService {

    @Getter
    private WalletRepo walletRepo;

    @Autowired
    public void setWalletRepo(WalletRepo walletRepo) {
        this.walletRepo = walletRepo;
    }
    @Transactional(rollbackFor = Exception.class)
    public void saveWallet(Wallet wallet) throws Exception {
//        walletRepo.save(wallet); JPA
        walletRepo.insertWalletQuery(wallet.getNoRekening(),wallet.getJumlahSaldo(),wallet.getCreatedBy(),wallet.getCreatedDate());
    }


    @Transactional(rollbackFor = {Exception.class})
    public void transferWallet(WalletDTO walletDTO) throws Exception
    {
        Optional<Wallet> nasabahPengirim = walletRepo.findByNoRekening(walletDTO.getRekeningAsal());
        if(nasabahPengirim.isEmpty())
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_REKENING_ASAL);
        }

        Optional<Wallet> nasabahPenerima = walletRepo.findByNoRekening(walletDTO.getRekeningPenerima());
        if(nasabahPenerima.isEmpty())
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_REKENING_PENERIMA);
        }

        if (walletDTO.getNominal() > nasabahPengirim.get().getJumlahSaldo()){
            throw new ResourceNotFoundException(ConstantMessage.WARNING_SALDO_LIMIT);
        }else {
            try {
                nasabahPengirim.get().setJumlahSaldo(nasabahPengirim.get().getJumlahSaldo()-walletDTO.getNominal());
                nasabahPenerima.get().setJumlahSaldo(nasabahPenerima.get().getJumlahSaldo()+walletDTO.getNominal());
            }catch (Exception e){
                throw new ResourceNotFoundException(ConstantMessage.WARNING_FAIL_TRANSFER);
            }
        }

    }

}
