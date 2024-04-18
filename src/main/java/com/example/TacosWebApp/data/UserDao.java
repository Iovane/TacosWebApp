package com.example.TacosWebApp.data;

import com.example.TacosWebApp.entities.User;


public interface UserDao {

    User findByUsername(String username);

    void save(User user);

}
