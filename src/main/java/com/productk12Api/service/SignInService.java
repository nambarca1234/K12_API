package com.productk12Api.service;

import com.productk12Api.model.UserDTO;
import org.springframework.http.ResponseEntity;

public interface SignInService {
    ResponseEntity<?> login(UserDTO dto);

}
