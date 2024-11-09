package com.backend.empowerpro.repository;

import com.backend.empowerpro.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountsRepo extends JpaRepository<Accounts,Long> {
    List<Accounts> findByCategory(String type);
}
