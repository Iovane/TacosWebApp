package com.example.TacosWebApp.data;

import com.example.TacosWebApp.entities.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}
