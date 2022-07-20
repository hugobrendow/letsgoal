package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.model.Posicao;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/letsclubes")
public class LetsClubeController {

    @GetMapping
    public List<LetsClube> findAll() {
        Posicao posicao = new Posicao(1L, "Goleiro");
        Formacao formacao = new Formacao(1l, "4-3-3", Arrays.asList(posicao));
        LetsClube letsClube = new LetsClube(1L, "Clubinho", formacao);
        return List.of(letsClube);
    }

    @PostMapping
    public LetsClube saveLetsClube(@RequestBody LetsClube letsClube) {
        return letsClube;
    }

    @GetMapping("/{id}")
    public LetsClube findById(@PathVariable Long id) {
        Posicao posicao = new Posicao(1L, "Goleiro");
        Formacao formacao = new Formacao(1l, "4-3-3", Arrays.asList(posicao));
        LetsClube letsClube = new LetsClube(1L, "Clubinho", formacao);
        return letsClube;
    }

    @PutMapping("/{id}")
    public LetsClube updateLetsClube(@PathVariable Long id,
                                     @RequestBody LetsClube letsClube) {
        return letsClube;
    }
}
