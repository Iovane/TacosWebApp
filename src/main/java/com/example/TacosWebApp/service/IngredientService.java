package com.example.TacosWebApp.service;

import com.example.TacosWebApp.entities.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient findById(String id);

    List<Ingredient> findAll();
}
