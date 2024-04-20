package com.example.TacosWebApp.data;

import com.example.TacosWebApp.entities.Taco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacoRepository extends JpaRepository<Taco, Long> {

    List<Taco> findTop5ByOrderByCreatedAtDesc();
}
