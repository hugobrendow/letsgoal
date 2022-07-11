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
    public List<LetsClube> findAll(){
        Posicao posicao = new Posicao();
        posicao.setNome("GOLEIRO");
        Formacao formacao = new Formacao(1l, "4-3-3", Arrays.asList(posicao));
        LetsClube clube = new LetsClube(1L, "Gabriel Team", formacao);

        return Arrays.asList(clube);
    }

    @PostMapping
    public LetsClube saveLetsClube(@RequestBody LetsClube letsClube){
        return letsClube;
    }

    @GetMapping("/{d}")
    public LetsClube findById(@PathVariable Long id){
        Posicao posicao = new Posicao();
        posicao.setNome("GOLEIRO");
        Formacao formacao = new Formacao(1l, "4-2-3-1", Arrays.asList(posicao));
        LetsClube clube = new LetsClube(id, "Outro Team", formacao);

        return clube;
    }
}
