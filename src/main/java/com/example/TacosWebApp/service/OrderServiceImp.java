package com.example.TacosWebApp.service;

import com.example.TacosWebApp.data.OrderRepository;
import com.example.TacosWebApp.entities.TacoOrder;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {

    OrderRepository orderRepo;

    public OrderServiceImp(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public void save(TacoOrder order) {
        orderRepo.save(order);
    }

    @Override
    @Transactional
    public void delete(TacoOrder tacoOrder) {
        orderRepo.delete(tacoOrder);
    }

}
