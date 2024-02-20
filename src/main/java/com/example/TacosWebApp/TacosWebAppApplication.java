package com.example.TacosWebApp;

import com.example.TacosWebApp.data.IngredientRepository;
import com.example.TacosWebApp.entities.Ingredient;
import com.example.TacosWebApp.entities.Ingredient.Type;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TacosWebAppApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(TacosWebAppApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}


	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo) {
		return args -> {
			repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
			repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
			repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
			repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
			repo.save(new Ingredient("DITM", "Diced Tomatoes", Type.VEGGIES));
			repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
			repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
			repo.save(new Ingredient("MOJA", "Monterrey Jack", Type.CHEESE));
			repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
			repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
			repo.save(new Ingredient("RNCH", "Ranch", Type.SAUCE));
			repo.save(new Ingredient("LEMO","Lemon", Type.CITRON));
			repo.save(new Ingredient("LIME","Lime", Type.CITRON));
			repo.save(new Ingredient("ORNG","Orange", Type.CITRON));
		};
	}
}
