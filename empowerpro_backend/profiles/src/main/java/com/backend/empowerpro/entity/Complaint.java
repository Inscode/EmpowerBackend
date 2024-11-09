package com.backend.empowerpro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Table(name = "complaints")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "about")
    private String about;

    @CreationTimestamp
    @Column(name = "date")
    private Date date;

    private String sender;

    @Column(name = "assigned_to")
    private String assignedTo;

    @Column(name = "description")
    private String description;

    @Column(name = "reply")
    private String reply;

    @Column(name = "files_to_upload", length = 1000)
    private String filesToUpload;

}

