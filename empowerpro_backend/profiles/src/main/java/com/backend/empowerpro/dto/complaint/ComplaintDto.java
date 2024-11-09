package com.backend.empowerpro.dto.complaint;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComplaintDto {
    private Long id;
    private String status;
    private String about;
    private Date date;
    private String sender;
    private String assignedTo;
    private String description;
    private String reply;
    private String filesToUpload;
}