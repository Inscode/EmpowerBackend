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
@Table(name = "accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accounts_id" ,nullable = false   )
    private Long id;

    @Column(name = "subject",nullable = false   )
    private String subject;

    @Column(name = "amount" ,nullable = false  )
    private Float amount;

    @Column(name = "date_of_transaction",nullable = false   )
    private Date dateOfTransaction;

    @Column(name = "category" ,nullable = false  )
    private String category;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
