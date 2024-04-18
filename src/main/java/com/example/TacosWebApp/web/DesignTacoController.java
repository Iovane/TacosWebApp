package com.example.TacosWebApp.web;

import com.example.TacosWebApp.data.IngredientRepository;
import com.example.TacosWebApp.data.TacoRepository;
import com.example.TacosWebApp.entities.Ingredient;
import com.example.TacosWebApp.entities.Ingredient.Type;
import com.example.TacosWebApp.entities.Taco;
import com.example.TacosWebApp.entities.TacoOrder;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;
    private final TacoRepository tacoRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository tacoRepo) {
        this.ingredientRepo = ingredientRepo;
        this.tacoRepo = tacoRepo;
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

        model.addAttribute("taco", new Taco());
        return "design";
    }

    @GetMapping("/recent")
    public String showRecentTacos(Model model) {
        List<Taco> recentTacos = tacoRepo.findTop5ByOrderByCreatedAtDesc();
        model.addAttribute("recentTacos", recentTacos);

        return "recent";
    }

    @GetMapping("/{id}")
    public Optional<Taco> tacoById(@PathVariable("id") Long id) {
        return tacoRepo.findById(id);
    }


    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder, Model model){
        if(errors.hasErrors()){
            locateViewWithIngredients(model);

            return "design";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        taco.setCreatedBy(authentication.getName());

        Taco saved = tacoRepo.save(taco);
        tacoOrder.addDesign(saved);

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
        List<Ingredient> ingredients = new ArrayList<>(ingredientRepo.findAll());
        Type[] types = Type.values();

        for(Type type: types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

}
