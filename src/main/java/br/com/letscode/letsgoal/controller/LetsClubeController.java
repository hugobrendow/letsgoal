package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.entity.*;
import br.com.letscode.letsgoal.service.LetsClubeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/letsClubes")
public class LetsClubeController {

    final LetsClubeService letsClubeService;

    @GetMapping
    public List<LetsClube> findAll() {
        return letsClubeService.findAll();
    }

    @PostMapping
    public LetsClube saveLetsClube(@RequestBody LetsClube letsClube) {
        return letsClubeService.saveLetsClube(letsClube);
    }

    @GetMapping("/{id}")
    public LetsClube findById(@PathVariable Long id, LetsClube letsClube) {
        return letsClubeService.findById(id);
    }

    @PutMapping("/{id}")
    public LetsClube updateLetsClube(@PathVariable Long id,
                                     @RequestBody LetsClube letsClube) {
        return letsClube;
    }
//    @GetMapping("/{id}")
//    public Jogador buyJogador(@PathVariable Long id, Jogador jogador){
//        return jogador;
//
//    }
}
