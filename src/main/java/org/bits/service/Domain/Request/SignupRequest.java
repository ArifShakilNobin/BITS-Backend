package org.bits.service.Domain.Request;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String password;
    private String role;  // Add role field

}