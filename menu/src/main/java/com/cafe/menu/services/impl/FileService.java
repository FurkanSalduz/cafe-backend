package com.cafe.menu.services.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class FileService {

    @Autowired
    private AmazonS3 s3Client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    public String uploadFile(MultipartFile file) {
        try {
            String fileName = generateFileName(file);

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());

            // Dosyayı Amazon S3'e yükleme
            s3Client.putObject(bucketName, fileName, file.getInputStream(), metadata);

            // Yüklenen dosyanın URL'sini döndürme
            return s3Client.getUrl(bucketName, fileName).toString();
        } catch (IOException e) {
            log.error("Dosya yükleme hatası: {}", e.getMessage());
            throw new RuntimeException("Dosya yüklenirken bir hata oluştu.", e);
        }
    }

    private String generateFileName(MultipartFile file) {
        return UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
    }
}
