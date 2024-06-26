package com.example.TacosWebApp.service;

import com.example.TacosWebApp.data.TacoRepository;
import com.example.TacosWebApp.entities.Taco;
import com.example.TacosWebApp.entities.TacoOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacoServiceImpl implements TacoService{

    TacoRepository tacoRepo;
    OrderService orderService;

    public TacoServiceImpl(TacoRepository tacoRepository, OrderService orderService) {
        this.tacoRepo = tacoRepository;
        this.orderService = orderService;
    }

    @Override
    public Taco findById(Long id) {
        Optional<Taco> tempTaco = tacoRepo.findById(id);

        Taco theTaco;
        if(tempTaco.isPresent()) {
            theTaco = tempTaco.get();
        } else {
            throw new RuntimeException("Taco not found");
        }

        return theTaco;
    }

    @Override
    public List<Taco> findTop5Tacos() {
        return tacoRepo.findTop5ByOrderByCreatedAtDesc();
    }

    @Override
    public void deleteById(Long id) {
        Optional<Taco> optionalTaco = tacoRepo.findById(id);

        optionalTaco.ifPresent(taco -> {
            TacoOrder tacoOrder = taco.getTacoOrder();
            tacoRepo.delete(taco);

            if (tacoOrder != null && tacoOrder.getTacos().isEmpty()) {
                orderService.delete(tacoOrder);
            }
        });
    }
}
