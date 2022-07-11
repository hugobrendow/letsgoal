package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.model.Posicao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/letsclubes")
public class LetsClubeController {

    @GetMapping
    public List<LetsClube> findAll(){
        Posicao posicao = new Posicao();
        posicao.setId(1L);
        posicao.setNome("Atacante");
        Formacao formacao = new Formacao(1L, "4-3-3", List.of(posicao));
        LetsClube letsClube = new LetsClube(1L, "Clube 1", formacao);
        return List.of(letsClube);
    }

    @GetMapping("/{id}")
    public LetsClube findById(@PathVariable Long id){
        Posicao posicao = new Posicao();
        posicao.setId(1L);
        posicao.setNome("Atacante");
        Formacao formacao = new Formacao(1L, "4-3-3", List.of(posicao));
        return new LetsClube(id, "Clube 1", formacao);
    }

    @PostMapping
    public LetsClube saveLetsClube(@RequestBody LetsClube letsClube){
        return letsClube;
    }


}
