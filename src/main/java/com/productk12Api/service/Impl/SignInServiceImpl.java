package com.productk12Api.service.Impl;

import com.productk12Api.Security.JwtProvider;
import com.productk12Api.model.BaseResponse;
import com.productk12Api.model.UserDTO;
import com.productk12Api.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SignInServiceImpl extends BaseResponse implements SignInService {
    @Autowired
    private JwtProvider provider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public ResponseEntity<?> login(UserDTO dto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = provider.createToken(authentication);
        return getResponseEntity(token);
    }
}
