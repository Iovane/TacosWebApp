package com.example.TacosWebApp.web;

import com.example.TacosWebApp.data.OrderRepository;
import com.example.TacosWebApp.data.UserDao;
import com.example.TacosWebApp.entities.TacoOrder;
import com.example.TacosWebApp.entities.User;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private final UserDao userDao;
    private final OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo, UserDao userDao) {
        this.orderRepo = orderRepo;
        this.userDao = userDao;
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
        User user = userDao.findByUsername(username);

        order.setUser(user);

        orderRepo.save(order);
        sessionStatus.setComplete();

        log.info("Processing order: {}", order);

        return "redirect:/";
    }
}
