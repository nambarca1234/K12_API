package com.productk12Api.service;

import com.productk12Api.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> save (User user, int [] rid);
    ResponseEntity<?> findByUsername (String username);
    User getByUsername(String username);
}
