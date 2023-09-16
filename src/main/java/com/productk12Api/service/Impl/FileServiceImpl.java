package com.productk12Api.service.Impl;

import com.productk12Api.model.BaseResponse;
import com.productk12Api.model.File;
import com.productk12Api.repository.FileRepository;
import com.productk12Api.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

@Service
public class FileServiceImpl extends BaseResponse implements FileService {
    @Autowired
    FileRepository repository;
    @Override
    @Transactional  //hoan thanh het cau lenh ms update vao database, sai lenh thi se tra lai nhu cu
    public ResponseEntity<?> save(MultipartFile multipartFile, int uid) {
        if(repository.existsByUid(uid)){
            repository.deleteByUid(uid);
        }
        repository.save(convertFile(multipartFile,uid));
        return getResponseEntity("success");
    }

    @Override
    public ResponseEntity<?> findByUid(int uid) {
        File file = repository.findFileByUid(uid);
        if(file ==null){
            file=repository.findFileByUid(1); // mac dinh neu file rong
        }
        return getResponseEntityFile(file);
    }
}
