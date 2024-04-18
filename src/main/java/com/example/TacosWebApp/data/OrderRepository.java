package com.example.TacosWebApp.data;

import com.example.TacosWebApp.entities.TacoOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<TacoOrder, Long> {


}
