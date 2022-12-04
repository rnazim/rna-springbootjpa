package com.bcafinance.rnaspringboot.repos;

import com.bcafinance.rnaspringboot.models.Foods;
import com.bcafinance.rnaspringboot.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepo extends JpaRepository<Foods,Long> {
    Optional<Foods> findByNameFood(String nameFood);
}
