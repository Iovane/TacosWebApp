package com.example.TacosWebApp.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Table(name = "users")
public class User {
    private static final Logger log = LoggerFactory.getLogger(User.class);
//    implements UserDetails

//    @Serial
//    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private final String username;

    @Column(name = "password")
    private final String password;

    @Column(name = "full_name")
    private final String fullName;

    @Column(name = "city")
    private final String city;

    @Column(name = "zip")
    private final String zip;

    @Column(name = "phone_number")
    private final String phoneNumber;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;


    public boolean isAdmin() {
        boolean isAdmin = this.getRoles()
                .stream()
                .anyMatch(role -> role.getName().equals("ROLE_ADMIN"));

        if (isAdmin) {
            log.info("User has ROLE_ADMIN role");
            return true;
        }

        return false;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
