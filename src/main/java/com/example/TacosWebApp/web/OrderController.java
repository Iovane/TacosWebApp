package com.example.TacosWebApp.web;

import com.example.TacosWebApp.entities.TacoOrder;
import com.example.TacosWebApp.entities.User;
import com.example.TacosWebApp.service.OrderService;
import com.example.TacosWebApp.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
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

    private final UserService userService;
    private final OrderService orderService;

    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus, Principal principal) {
        if (errors.hasErrors()){
            return "orderForm";
        }

        String username = principal.getName();
        User user = userService.findByUsername(username);

        order.setUser(user);

        orderService.save(order);
        sessionStatus.setComplete();

        log.info("Processing order: {}", order);

        return "redirect:/";
    }
}
