package com.productk12Api.controller;

import com.productk12Api.Security.JwtProvider;
import com.productk12Api.model.User;
import com.productk12Api.model.UserDTO;
import com.productk12Api.service.SignInService;
import com.productk12Api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
@Autowired
private SignInService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO user) {
        User user1 = new User();
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        return userService.save(user1, user.getRid());

    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO user) {
      return service.login(user);
    }

}
