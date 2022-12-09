package com.bcafinance.rnaspringboot.repos;

import com.bcafinance.rnaspringboot.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;

public interface WalletRepo extends JpaRepository<Wallet,Long> {
    Optional<Wallet> findByNoRekening(String noRekening);

    @Modifying
    @Query(
            value =
                    "insert into MstWallet (noRekening,jumlahSaldo,CreatedBy,CreatedDate)" +
                            " values (:noRekening, :jumlahSaldo, :createdBy, :createdDate )",
            nativeQuery = true)
    void insertWalletQuery(@Param("noRekening") String noRekening,
                        @Param("jumlahSaldo") Double jumlahSaldo,
                        @Param("createdBy") String createdBy,
                        @Param("createdDate") Date createdDate);
}
