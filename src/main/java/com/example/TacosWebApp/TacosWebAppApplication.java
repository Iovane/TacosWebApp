package com.example.TacosWebApp;

import com.example.TacosWebApp.data.IngredientRepository;
import com.example.TacosWebApp.data.TacoRepository;
import com.example.TacosWebApp.data.UserRepository;
import com.example.TacosWebApp.entities.Ingredient;
import com.example.TacosWebApp.entities.Ingredient.Type;
import com.example.TacosWebApp.entities.Taco;
import com.example.TacosWebApp.entities.User;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.Time;
import java.util.Date;

@SpringBootApplication
public class TacosWebAppApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(TacosWebAppApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		registry.addViewController("login");
	}


}
