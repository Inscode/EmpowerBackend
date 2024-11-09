package com.backend.empowerpro.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id" ,nullable = false   )
    private Long id;

    @Column(name = "supplier_name",nullable = false   )
    private String supplierName;

    @Column(name = "contact_email" ,nullable = false  )
    private String contactEmail;

    @Column(name = "contact_phoneNo" ,nullable = false  )
    private String contactPhoneNo;

    @Column(name = "supplier_description",nullable = false   )
    private String supplierDescription;


    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}
