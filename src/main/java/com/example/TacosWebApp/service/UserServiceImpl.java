package com.example.TacosWebApp.service;

import com.example.TacosWebApp.data.RoleDao;
import com.example.TacosWebApp.data.UserDao;
import com.example.TacosWebApp.entities.Role;
import com.example.TacosWebApp.entities.User;
import com.example.TacosWebApp.security.RegistrationForm;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final RoleDao roleDao;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao, BCryptPasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUserName(String username) {

        return userDao.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                                                                        user.getPassword(),
                                                                        mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).toList();
    }

    @Override
    public void save(RegistrationForm userForm) {
        User user = userForm.toUser(passwordEncoder);

        // give user default role of "user"
        user.setRoles(List.of(roleDao.findRoleByName("ROLE_USER")));

        userDao.save(user);
    }
}
