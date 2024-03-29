package com.example.TacosWebApp.security;

import com.example.TacosWebApp.data.UserRepository;
import com.example.TacosWebApp.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User user = userRepo.findByUsername(username);
            if (user != null) return user;

            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/register", "/login").permitAll()
//                        .requestMatchers("/design", "/orders", "/orders/current").hasRole("USER")
                        .requestMatchers("/", "/**").permitAll()

                );

        http
                .formLogin(form -> form
                        .loginPage("/login").defaultSuccessUrl("/design", true)
                );


        return http.build();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
//    }

//    @Bean
//    @Primary
//    public AuthenticationManagerBuilder userConfigure(AuthenticationManagerBuilder auth) throws Exception {
//        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .withUser("Kong")
//                .password(bcrypt.encode("12345"))
//                .roles("USER")
//                .and()
//                .passwordEncoder(bcrypt);
//        return auth;
//    }
}
