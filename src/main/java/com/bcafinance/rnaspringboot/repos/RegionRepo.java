package com.bcafinance.rnaspringboot.repos;

import com.bcafinance.rnaspringboot.models.Customers;
import com.bcafinance.rnaspringboot.models.Regions;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface RegionRepo extends JpaRepository<Regions,Long> {
    Optional<Regions> findBykodeRegion(String kodeRegion);
}
