package com.example.TacosWebApp.web;

import com.example.TacosWebApp.entities.Ingredient;
import com.example.TacosWebApp.entities.Ingredient.Type;
import com.example.TacosWebApp.entities.Taco;
import com.example.TacosWebApp.entities.TacoOrder;
import com.example.TacosWebApp.service.IngredientService;
import com.example.TacosWebApp.service.TacoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private final IngredientService ingredientService;
    private final TacoService tacoService;

    @Autowired
    public DesignTacoController(IngredientService ingredientService, TacoService tacoService) {
        this.ingredientService = ingredientService;
        this.tacoService = tacoService;
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder tacoOrder(){
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        locateViewWithIngredients(model);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info(auth.getName());

        model.addAttribute("taco", new Taco());
        return "design";
    }

//    @GetMapping("/{id}")
//    public Taco tacoById(@PathVariable("id") Long id) {
//        return tacoService.findById(id);
//    }


    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder, Model model, Principal principal){
        if(errors.hasErrors()){
            locateViewWithIngredients(model);

            return "design";
        }

        taco.setCreatedBy(principal.getName());

        tacoOrder.addDesign(taco);

        log.info("Processing taco: " + taco);

        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    private void locateViewWithIngredients(Model model){
        List<Ingredient> ingredients = new ArrayList<>(ingredientService.findAll());
        Type[] types = Type.values();

        for(Type type: types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

}
