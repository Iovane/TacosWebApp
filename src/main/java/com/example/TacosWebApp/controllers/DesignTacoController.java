package com.example.TacosWebApp.controllers;

import com.example.TacosWebApp.data.IngredientRepository;
import com.example.TacosWebApp.data.TacoRepository;
import com.example.TacosWebApp.entities.Ingredient;
import com.example.TacosWebApp.entities.Ingredient.Type;
import com.example.TacosWebApp.entities.Taco;
import com.example.TacosWebApp.entities.TacoOrder;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;
    private final TacoRepository tacoRepo;

    public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository tacoRepo) {
        this.ingredientRepo = ingredientRepo;
        this.tacoRepo = tacoRepo;
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder tacoOrder(){
        return new TacoOrder();
    }


    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepo.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType((List<Ingredient>) ingredients, type));
        }
    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("taco", new Taco());
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid @ModelAttribute("taco") Taco taco, Errors errors, TacoOrder tacoOrder){
        if(errors.hasErrors()){
            return "design";
        }

        Taco saved = tacoRepo.save(taco);
        tacoOrder.addTaco(saved);

        log.info("Processing taco: " + taco);

        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
