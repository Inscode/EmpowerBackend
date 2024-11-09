package com.backend.empowerpro.service.impl;


import com.backend.empowerpro.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileServiceImp implements FileService {

    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {
        //get the name of the file
        String fileName = Objects.requireNonNull(file.getOriginalFilename()).trim();
        //Get the file path
        String filePath = path + File.separator + fileName;
        //File Object
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }

        //Copy the file  or Upload File to the path
        Files.copy(file.getInputStream(), Paths.get(filePath));
        return fileName;
    }

    @Override
    public InputStream getResourceFile(String path, String fileName) throws FileNotFoundException {
        String filePath = path + File.separator + fileName;
        return new FileInputStream(filePath);
    }
}
