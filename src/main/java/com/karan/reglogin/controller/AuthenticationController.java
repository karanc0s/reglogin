package com.karan.reglogin.controller;

import com.karan.reglogin.payload.request.AuthRequest;
import com.karan.reglogin.payload.request.RegisterRequest;
import com.karan.reglogin.payload.response.AuthResponse;
import com.karan.reglogin.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {


    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest req
    ){
        return ResponseEntity.ok(authService.register(req));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest req
    ){
        return ResponseEntity.ok(authService.authenticate(req));
    }


}
