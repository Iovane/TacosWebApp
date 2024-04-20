package com.example.TacosWebApp.security;

import com.example.TacosWebApp.entities.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    @NotNull(message = "is required")
    @Size(min = 5, message = "should be at least 5 characters")
    private String username;

    @NotNull(message = "is required")
    @Size(min = 7, message = "should be at least 7 characters")
    private String password;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String fullName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String city;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String zip;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), fullName, city, zip, phone);
    }
}

