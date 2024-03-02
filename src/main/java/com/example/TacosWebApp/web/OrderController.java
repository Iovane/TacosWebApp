package com.example.TacosWebApp.web;

import com.example.TacosWebApp.data.OrderRepository;
import com.example.TacosWebApp.data.UserRepository;
import com.example.TacosWebApp.entities.TacoOrder;
import com.example.TacosWebApp.entities.User;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private UserRepository userRepo;
    private final OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo, UserRepository userRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus, Principal principal){
        if (errors.hasErrors()){
            return "orderForm";
        }

        String username = principal.getName();
        User user = userRepo.findByUsername(username);

        order.setUser(user);

        orderRepo.save(order);
        sessionStatus.setComplete();

        log.info("Processing order: " + order);

        return "redirect:/";
    }
}
