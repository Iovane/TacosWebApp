package com.example.TacosWebApp.service;

import com.example.TacosWebApp.entities.Taco;

import java.util.List;

public interface TacoService {

    void deleteById(Long id);

    List<Taco> findTop5Tacos();

    Taco findTacoById(Long theId);
}
