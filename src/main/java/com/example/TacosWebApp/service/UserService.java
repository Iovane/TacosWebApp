package com.example.TacosWebApp.service;

import com.example.TacosWebApp.entities.User;
import com.example.TacosWebApp.security.RegistrationForm;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String username);

    void save(RegistrationForm userForm);
}
