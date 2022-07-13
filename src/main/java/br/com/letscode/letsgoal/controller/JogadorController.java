package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Jogador;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @GetMapping
    public List<Jogador> findAll(){
        Jogador jogador = new Jogador(1L, "Provável",11.16d, 5.45d, 13, "Cássioooo", "Cássio", "foto");
        List<Jogador> jogadores = List.of(jogador);
        return jogadores;
    }

    @GetMapping
    public Jogador saveJogador(@RequestBody Jogador jogador){
        return jogador;
    }

    @GetMapping("/{id}")
    public Jogador findById(@RequestParam Long id){
        Jogador jogador = new Jogador(1L, "Provável",11.16d, 5.45d, 13, "Cássioooo", "Cássio", "foto");
        return jogador;
    }

    @PutMapping("/{id}")
    public Jogador updateJogador (@RequestParam Long id,
                                  @RequestBody Jogador jogador){
        return jogador;
    }


}
