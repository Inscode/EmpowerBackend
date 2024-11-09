package com.backend.empowerpro.repository;

import com.backend.empowerpro.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveRepo extends JpaRepository<Leave, Long> {
    Optional<Leave> findByLeaveType(String type);
    @Query("SELECT l FROM Leave l WHERE (:status IS NULL OR l.status = :status) AND l.startDate >= :startDate")
    List<Leave> findByStatusAndDateRange(@Param("status") String status, @Param("startDate") LocalDate startDate);
}
