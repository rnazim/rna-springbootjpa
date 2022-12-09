package com.bcafinance.rnaspringboot.repos;

import com.bcafinance.rnaspringboot.models.UjianAkhir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UjianAkhirRepo extends JpaRepository<UjianAkhir,Long> {
    Optional<UjianAkhir> findByVar1(Integer Var1);

    @Modifying
    @Query(
            value =
                    "insert into UjianAkhir (var1,var2,var3)" +
                            " values (:var1, :var2, :var3)",
            nativeQuery = true)
    void insertUjianAkhirQuery(@Param("var1") Integer var1,
                           @Param("var2") Double var2,
                           @Param("var3") String var3);
}
