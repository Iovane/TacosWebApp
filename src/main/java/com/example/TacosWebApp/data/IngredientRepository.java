package com.example.TacosWebApp.data;

import com.example.TacosWebApp.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
