package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Posicao;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/letsClube")
public class LetsClubeController {
    @GetMapping
    public List<Formacao> findAll() {
        Posicao posicao = new Posicao();
        posicao.setNome("GOLEIRO");
        Formacao formacao = new Formacao(1l, "4-3-3", Arrays.asList(posicao));
        return Arrays.asList(formacao);
    }

    @PostMapping
    public Formacao saveFormacao(@RequestBody Formacao formacao) {
        // SERVIÇO - REGRA DE NEGÓCIO
        return formacao;
    }

    @GetMapping("/{id}")
    public Formacao findById(@PathVariable Long id) {
        Posicao posicao = new Posicao();
        posicao.setNome("GOLEIRO");
        Formacao formacao = new Formacao(id, "4-3-3", Arrays.asList(posicao));
        return formacao;
    }

}
