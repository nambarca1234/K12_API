package com.productk12Api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    ResponseEntity<?> save(MultipartFile multipartFile, int uid);
    ResponseEntity<?> findByUid(int uid);
}
