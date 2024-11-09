package com.backend.empowerpro.controller;

import com.backend.empowerpro.service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/file/")

public class FileController {

    private final FileService fileService;
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    public FileController(FileService fileService, FileService fileService1){

        this.fileService = fileService1;
    }
    @Value("${project.employeeProfile}")
    private String profilePath;
    @Value("${project.applicantsResume}")
    private String resumePath;
    @Value("${project.complaints}")
    private String complaintsPath;

    @PostMapping("/profile/upload")
    public ResponseEntity<String> uploadProfileHandler(@RequestPart MultipartFile file) throws IOException {
        String uploadedFileName =  fileService.uploadFile(profilePath,file);
        return ResponseEntity.ok("File Upload : " + uploadedFileName);
    }
    @PostMapping("/resume/upload")
    public ResponseEntity<String> uploadResumeFileHandler(@RequestPart MultipartFile file) throws IOException {
        String uploadedFileName =  fileService.uploadFile(resumePath,file);
        return ResponseEntity.ok("File Upload : " + uploadedFileName);
    }
    @PostMapping("/complaints/upload")
    public ResponseEntity<String> uploadComplaintsFileHandler(@RequestPart MultipartFile file) throws IOException {
        String uploadedFileName =  fileService.uploadFile(complaintsPath,file);
        return ResponseEntity.ok("File Upload : " + uploadedFileName);
    }
//    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/profile/{filename}")
    public void serveProfileHandler(@PathVariable String filename, HttpServletResponse response) throws IOException {
        InputStream resourceFile = fileService.getResourceFile(profilePath,filename);
        logger.info("get file method called Successfully");
        // Determine the file's content type
        Path filePath = Paths.get(profilePath, filename);
        logger.info("file path Created");
        String contentType = Files.probeContentType(filePath);
        logger.info("content type created");
        // If content type cannot be determined, default to application/octet-stream
        if (contentType == null) {
            contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        // Set the content type
        response.setContentType(contentType);
        // Copy the file contents to the response output stream

        StreamUtils.copy(resourceFile, response.getOutputStream());
        logger.info("Copy the file contents to the response output stream");
    }

    @GetMapping("/applicants/{filename}")
    public void serveResumeFileHandler(@PathVariable String filename, HttpServletResponse response) throws IOException {
        InputStream resourceFile = fileService.getResourceFile(resumePath, filename);
        // Determine the file's content type
        Path filePath = Paths.get(resumePath, filename);
        String contentType = Files.probeContentType(filePath);
        // If content type cannot be determined, default to application/octet-stream
        if (contentType == null) {
            contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        // Set the content type
        response.setContentType(contentType);
        // Copy the file contents to the response output stream
        StreamUtils.copy(resourceFile, response.getOutputStream());
    }

    @GetMapping("/complaints/{filename}")
    public void serveComplaintsFileHandler(@PathVariable String filename, HttpServletResponse response) throws IOException {
        InputStream resourceFile = fileService.getResourceFile(complaintsPath, filename);
        // Determine the file's content type
        Path filePath = Paths.get(complaintsPath, filename);
        String contentType = Files.probeContentType(filePath);
        // If content type cannot be determined, default to application/octet-stream
        if (contentType == null) {
            contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        // Set the content type
        response.setContentType(contentType);
        // Copy the file contents to the response output stream
        StreamUtils.copy(resourceFile, response.getOutputStream());
    }




}