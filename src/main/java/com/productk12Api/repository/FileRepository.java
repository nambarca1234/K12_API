package com.productk12Api.repository;

import com.productk12Api.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {
    File findFileByUid(int uid);
    void deleteByUid(int uid);
    Boolean existsByUid(int uid);
}
