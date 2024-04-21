package com.example.TacosWebApp.converters;

import com.example.TacosWebApp.entities.Ingredient;
import com.example.TacosWebApp.service.IngredientService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientService ingredientService;

    public IngredientByIdConverter(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientService.findById(id);
    }
}
