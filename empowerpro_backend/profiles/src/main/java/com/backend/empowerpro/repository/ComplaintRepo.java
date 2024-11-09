package com.backend.empowerpro.repository;


import com.backend.empowerpro.entity.Complaint;
import com.backend.empowerpro.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ComplaintRepo extends JpaRepository<Complaint,Long> {
    List<Complaint> findByAssignedTo(String role);

    List<Complaint> findBySender(String sender);
}
