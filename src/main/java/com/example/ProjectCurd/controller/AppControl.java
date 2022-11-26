package com.example.ProjectCurd.controller;

import com.example.ProjectCurd.entity.Users;
import com.example.ProjectCurd.model.AuthanticationRequest;
import com.example.ProjectCurd.model.AuthanticationResponse;
import com.example.ProjectCurd.repository.UserRepo;
import com.example.ProjectCurd.security.Jwt.JwtUtil;
import com.example.ProjectCurd.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppControl {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    UserRepo userRepo;
    String s = "";

    @RequestMapping("/api")
    public List<Users> Hellow() {
        return userRepo.findAll();
    }

    @RequestMapping("/api/user")
    public String getdat() {

        return jwtUtil.extractUsername(s);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthToken(@RequestBody AuthanticationRequest request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())

            );
            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(request.getUsername());
            final String jwt = jwtUtil.generateToken(userDetails);
            s = jwt;
            return ResponseEntity.ok(new AuthanticationResponse(jwt));
        } catch (Exception e) {
            System.out.println("error");
        }
        return null;
    }


}
