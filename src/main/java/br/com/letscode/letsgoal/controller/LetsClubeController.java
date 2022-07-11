package br.com.letscode.letsgoal.controller;


import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.model.Posicao;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/lets-clubes")
public class LetsClubeController {

    @GetMapping
    public List<LetsClube> findAll(){

        Posicao posicao = new Posicao();
        posicao.setNome("ATACANTE");
        Formacao formacao = new Formacao(1l, "4-3-3", Arrays.asList(posicao));
        LetsClube letsClube = new LetsClube(1L,"LetsClube", formacao);
        List<LetsClube> letsClubes = List.of(letsClube);

        return letsClubes;
    }

    @GetMapping("/{id}")
    public LetsClube findById(@PathVariable Long id){

        Posicao posicao = new Posicao();
        posicao.setNome("ATACANTE");
        Formacao formacao = new Formacao(1l, "4-3-3", Arrays.asList(posicao));
        LetsClube letsClube = new LetsClube(id,"LetsClube", formacao);

        return letsClube;
    }

    @PostMapping
    public LetsClube saveLetsClube(@RequestBody LetsClube letsClube){
        return letsClube;
    }

    @PutMapping("/{id}")
    public LetsClube updateLetsClube(@PathVariable Long id, @RequestBody LetsClube letsClube){
        return letsClube;
    }


    public Jogador buyPlayer(Jogador jogador){
        return jogador;
    }

    public Formacao chooseFormation(LetsClube letsClube, Formacao formacao){
        letsClube.formacao = formacao;
        return formacao;
    }


}
