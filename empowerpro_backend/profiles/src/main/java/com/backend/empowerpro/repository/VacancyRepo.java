package com.backend.empowerpro.repository;


import com.backend.empowerpro.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface VacancyRepo extends JpaRepository<Vacancy,Long> {
    Optional<Vacancy> findByJobTitle(String title);
}
