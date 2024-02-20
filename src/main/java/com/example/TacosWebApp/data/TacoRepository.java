package com.example.TacosWebApp.data;

import com.example.TacosWebApp.entities.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
