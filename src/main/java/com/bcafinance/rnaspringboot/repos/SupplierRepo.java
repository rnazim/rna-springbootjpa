package com.bcafinance.rnaspringboot.repos;

import com.bcafinance.rnaspringboot.models.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepo extends JpaRepository<Suppliers, Long> {
    Optional<Suppliers> findByEmailSupplier(String emailSupplier);
    List<Suppliers> searchByNameSupplierStartsWith(String nameSupplier);
    Optional<Suppliers> findByNameSupplier(String nameSupplier);
    List<Suppliers> searchByNameSupplierLike(String nameSupplier);
    Optional<Suppliers> findByNameSupplierLike(String nameSupplier);
    List<Suppliers> searchByNameSupplierNotLike(String nameSupplier);
    List<Suppliers> findByNameSupplierNotLike(String nameSupplier);

}
