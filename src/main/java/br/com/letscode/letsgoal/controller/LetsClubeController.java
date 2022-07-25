package br.com.letscode.letsgoal.controller;


import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.service.LetsClubeService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/lets-clubes")
public class LetsClubeController {

    final LetsClubeService letsClubeService;

    public LetsClubeController(LetsClubeService letsClubeService) {
        this.letsClubeService = letsClubeService;
    }

    @GetMapping
    public List<LetsClube> findAll(){

        return letsClubeService.findAll();
    }

    @GetMapping("/{id}")
    public LetsClube findById(@PathVariable Long id){
        return letsClubeService.findById(id);
    }

    @PostMapping
    public LetsClube saveLetsClube(@RequestBody LetsClube letsClube){
        return letsClubeService.saveLetsClube(letsClube);
    }

    @PutMapping("/{id}")
    public LetsClube updateLetsClube(@PathVariable Long id, @RequestBody LetsClube letsClube){
        return letsClube;
    }


}
