package com.example.TacosWebApp.data;

import com.example.TacosWebApp.entities.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder tacoOrder);
}
