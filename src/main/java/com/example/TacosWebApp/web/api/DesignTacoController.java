//package com.example.TacosWebApp.web.api;
//
//import com.example.TacosWebApp.data.TacoRepository;
//import com.example.TacosWebApp.entities.Taco;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(path="/design", produces="application/json")
//@CrossOrigin(origins="*")
//public class DesignTacoController {
//    private final TacoRepository tacoRepo;
//    public DesignTacoController(TacoRepository tacoRepo) {
//        this.tacoRepo = tacoRepo;
//    }
//
//    @GetMapping("/recent")
//    public Iterable<Taco> recentTacos() {
//        PageRequest page = PageRequest.of(
//                0, 12, Sort.by("createdAt").descending());
//        return tacoRepo.findAll(page).getContent();
//    }
//}
