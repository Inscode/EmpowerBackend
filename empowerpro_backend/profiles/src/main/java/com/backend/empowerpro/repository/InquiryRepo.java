package com.backend.empowerpro.repository;

import com.backend.empowerpro.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepo extends JpaRepository<Inquiry,Long> {
}
