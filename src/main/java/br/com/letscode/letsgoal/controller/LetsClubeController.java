package br.com.letscode.letsgoal.controller;


import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.LetsClube;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/letsclubes")
public class LetsClubeController {
    @GetMapping
    public List<LetsClube> findAll() {
        LetsClube letsClube = new LetsClube();
        return List.of(letsClube);
    }

    @PostMapping
    public LetsClube saveLetsClube(@RequestBody LetsClube letsClube) {
        return letsClube;
    }

    @GetMapping("/{id}")
    public LetsClube findById(@PathVariable Long id) {
        return new LetsClube();
    }

    @PutMapping("/{id}")
    public LetsClube updateLetsClube(@PathVariable Long id, @RequestBody LetsClube letsClube) {
        return letsClube;
    }

    //Fazer comprarjogador
    //Escolher formação
}
