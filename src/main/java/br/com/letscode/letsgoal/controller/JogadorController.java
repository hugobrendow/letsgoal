package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Jogador;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/jogadors")
public class JogadorController {
    @GetMapping
    public List<Jogador> findAll() {
        Jogador jogador = new Jogador();

        //REGRAS

        return Arrays.asList(jogador);
    }

    @GetMapping("{/id}")
    public Jogador findById(@PathVariable Long id){
        Jogador jogador = new Jogador();

        //REGRAS

        return jogador;
    }

    @PostMapping
    public Jogador saveJogador(@RequestBody Jogador jogador){

        //REGRAS

        return jogador;
    }

    @PutMapping("{/id}")
    public Jogador updateJogador(@PathVariable Long id, @RequestBody Jogador jogador){

        //REGRAS

        return jogador;
    }

}

