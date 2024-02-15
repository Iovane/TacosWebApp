package com.example.TacosWebApp.converters;

import com.example.TacosWebApp.entities.Ingredient;
import com.example.TacosWebApp.entities.Ingredient.Type;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter(){
        ingredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
        ingredientMap.put("COTO", new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
        ingredientMap.put("GRBF", new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
        ingredientMap.put("CARN", new Ingredient("CARN", "Carnitas", Type.PROTEIN));
        ingredientMap.put("DITM", new Ingredient("DITM", "Diced Tomatoes", Type.VEGGIES));
        ingredientMap.put("LETC", new Ingredient("LETC", "Lettuce", Type.VEGGIES));
        ingredientMap.put("CHED", new Ingredient("CHED", "Cheddar", Type.CHEESE));
        ingredientMap.put("MOJA", new Ingredient("MOJA", "Monterrey Jack", Type.CHEESE));
        ingredientMap.put("SLSA", new Ingredient("SLSA", "Salsa", Type.SAUCE));
        ingredientMap.put("SRCR", new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
        ingredientMap.put("RNCH", new Ingredient("RNCH", "Ranch", Type.SAUCE));
        ingredientMap.put("LEMO", new Ingredient("LEMO", "Lemon", Type.CITRON));
        ingredientMap.put("LIME", new Ingredient("LIME", "Lime", Type.CITRON));
        ingredientMap.put("ORNG", new Ingredient("ORNG", "Orange", Type.CITRON));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
