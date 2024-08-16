package com.karan.reglogin.service;


import com.karan.reglogin.model.Role;
import com.karan.reglogin.model.User;
import com.karan.reglogin.payload.request.AuthRequest;
import com.karan.reglogin.payload.request.RegisterRequest;
import com.karan.reglogin.payload.response.AuthResponse;
import com.karan.reglogin.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AuthService  {

    @Autowired
    private UserRepo repo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthJwtService authJwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest req) {
        User user = User.builder()
                .email(req.getEmail())
                .firstName(req.getFirstName())
                .lastName(req.getLastName())
                .email(req.getEmail())
                .password(encoder.encode(req.getPassword()))
                .role(req.getRole())
//                .role(Role.USER)
                .build();

        repo.save(user);
        String token = authJwtService.generateToken(user);

        return AuthResponse.builder()
                .token(token)
                .role(user.getRole())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public AuthResponse authenticate(AuthRequest req) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getEmail(),
                        req.getPassword()
                )
        );
        User user = repo.findByEmail(req.getEmail()).orElseThrow();
        String token = authJwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token).role(user.getRole())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName()).build();
    }

}
