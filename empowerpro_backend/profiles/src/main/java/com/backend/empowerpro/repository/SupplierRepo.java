package com.backend.empowerpro.repository;

import com.backend.empowerpro.entity.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface SupplierRepo extends JpaRepository<Suppliers,Long> {
    Optional<Suppliers> findBySupplierName(String supplier_name);
}


