package com.karan.reglogin.payload.response;

import com.karan.reglogin.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
@NonNull
public class AuthResponse {

    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private String token;

}
