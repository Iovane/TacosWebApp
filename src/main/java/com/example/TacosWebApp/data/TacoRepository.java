package com.example.TacosWebApp.data;

import com.example.TacosWebApp.entities.Taco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacoRepository extends JpaRepository<Taco, Long> {
}
