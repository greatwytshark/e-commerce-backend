package com.zpay.zpay.services;

import com.zpay.zpay.domain.Role;
import com.zpay.zpay.domain.User;
import com.zpay.zpay.dto.LoginResponseDTO;
import com.zpay.zpay.repository.RoleRepo;
import com.zpay.zpay.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;

    public User registerUser(String username, String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepo.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        User user = new User(null, null, null, username, null, encodedPassword, authorities);
        return userRepo.save(user);
    }

    public LoginResponseDTO loginUser(String username, String password){
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
            String token = tokenService.generateJwt(auth);
            return new  LoginResponseDTO(userRepo.findByUsername(username).get(), token);
    }

}
