package com.bcafinance.rnaspringboot.dto;

import com.bcafinance.rnaspringboot.utils.ConstantMessage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletDTO {

    @NotEmpty(message = ConstantMessage.WARNING_REKENING_ASAL)
    @Length(message = ConstantMessage.WARNING_NAME_MAX_LENGTH,max = 90)
    private String rekeningAsal;


    @NotEmpty(message = ConstantMessage.WARNING_REKENING_PENERIMA)
    @Length(message = ConstantMessage.WARNING_NAME_MAX_LENGTH,max = 90)
    private String rekeningPenerima;

    @NotNull(message = ConstantMessage.WARNING_NOMINAL_REQUIRED)
    private Double nominal;



    public String getRekeningAsal() {
        return rekeningAsal;
    }

    public void setRekeningAsal(String rekeingAsal) {
        this.rekeningAsal = rekeingAsal;
    }

    public String getRekeningPenerima() {
        return rekeningPenerima;
    }

    public void setRekeningPenerima(String rekeningPenerima) {
        this.rekeningPenerima = rekeningPenerima;
    }

    public Double getNominal() {
        return nominal;
    }

    public void setNominal(Double nominal) {
        this.nominal = nominal;
    }

}
