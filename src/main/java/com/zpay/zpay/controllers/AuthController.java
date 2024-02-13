package com.zpay.zpay.controllers;

import com.zpay.zpay.domain.User;
import com.zpay.zpay.dto.LoginResponseDTO;
import com.zpay.zpay.dto.UserDTO;
import com.zpay.zpay.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody UserDTO user){
        return authService.registerUser(user.getUsername(), user.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody UserDTO user){
        return authService.loginUser(user.getUsername(), user.getPassword());
    }

}
