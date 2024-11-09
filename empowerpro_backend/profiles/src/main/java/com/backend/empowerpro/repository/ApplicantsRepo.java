package com.backend.empowerpro.repository;

import com.backend.empowerpro.entity.Applicants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantsRepo extends JpaRepository<Applicants,Long> {

}
