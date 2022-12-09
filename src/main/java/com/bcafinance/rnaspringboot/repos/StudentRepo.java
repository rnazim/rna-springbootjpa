package com.bcafinance.rnaspringboot.repos;

import com.bcafinance.rnaspringboot.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
    Page<Student> findByFullNameIsContaining(String name, Pageable pageable);
}