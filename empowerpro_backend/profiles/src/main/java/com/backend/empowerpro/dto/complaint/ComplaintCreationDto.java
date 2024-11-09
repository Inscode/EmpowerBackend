package com.backend.empowerpro.dto.complaint;

import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class ComplaintCreationDto {
    private Long id;
    private String status = "Pending";
    private String about;
    private Date date;// Subject of the complaint
    private String sender; // You may want to include this field for the sender's details
    private String assignedTo; // The person to whom the complaint is assigned
    private String description; // Description of the complaint
    private String reply; // Reply field (if applicable)
    private String filesToUpload; // List to support multiple file uploads

}
