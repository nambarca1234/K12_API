package com.productk12Api.service.Impl;

import com.productk12Api.model.BaseResponse;
import com.productk12Api.model.Role;
import com.productk12Api.model.User;
import com.productk12Api.repository.RoleRepository;
import com.productk12Api.repository.UserRepository;
import com.productk12Api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends BaseResponse implements UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Override
    public ResponseEntity<?> save(User user, int[] rid) {
        List<Role> roles = new ArrayList<>();
        for ( int id: rid) {
            Optional<Role> optionalRole = roleRepository.findById(id);
            if (optionalRole.isEmpty()){
                throw new  RuntimeException("rid invalid");
            }
            roles.add(optionalRole.get());
        }
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(roles);
        return getResponseEntity(repository.save(user));
    }

    @Override
    public ResponseEntity<?> findByUsername(String username) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return repository.findByUsername(username);
    }
}
