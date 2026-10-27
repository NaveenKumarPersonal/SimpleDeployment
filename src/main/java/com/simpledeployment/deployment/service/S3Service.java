package com.simpledeployment.deployment.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface S3Service {

    String upload(MultipartFile file) throws IOException;
}
