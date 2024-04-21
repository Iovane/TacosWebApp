package com.example.TacosWebApp.service;

import com.example.TacosWebApp.data.IngredientRepository;
import com.example.TacosWebApp.entities.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImp implements IngredientService {

    private final IngredientRepository ingredientRepo;

    public IngredientServiceImp(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient findById(String id) {

        Optional<Ingredient> tempIngredient = ingredientRepo.findById(id);

        Ingredient theIngredient;

        if (tempIngredient.isPresent()) {
            theIngredient = tempIngredient.get();
        } else {
            throw new IllegalArgumentException("Ingredient not found");
        }

        return theIngredient;
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepo.findAll();
    }
}
