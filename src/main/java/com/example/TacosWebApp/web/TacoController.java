package com.example.TacosWebApp.web;

import com.example.TacosWebApp.entities.Taco;
import com.example.TacosWebApp.service.OrderService;
import com.example.TacosWebApp.service.TacoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("recent")
public class TacoController {

    TacoService tacoService;

    public TacoController(TacoService tacoService) {
        this.tacoService = tacoService;
    }


    @GetMapping
    public String showRecentTacos(Model model) {
        List<Taco> recentTacos = tacoService.findTop5Tacos();
        model.addAttribute("recentTacos", recentTacos);

        return "recent";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("tacoId") Long theId) {

        tacoService.deleteById(theId);

        return "redirect:/recent";
    }
}
