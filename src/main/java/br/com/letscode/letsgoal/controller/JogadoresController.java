package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Jogadores;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadoresController {

    @GetMapping
    public List<Jogadores> findAll(){
        Jogadores jogador = new Jogadores(1L, "José","Zé", "foto.jpg", 5, 2 , new BigDecimal(13000), "foto");
        return List.of(jogador);
    }

    @GetMapping
    public Jogadores saveJogador(@RequestBody Jogadores jogador){
        return jogador;
    }

    @GetMapping("/{id}")
    public Jogadores findById(@RequestParam Long id){
        Jogadores jogador = new Jogadores(1L, "José","Zé", "foto.jpg", 5, 2 , new BigDecimal(13000), "foto");
        return jogador;
    }

    @PutMapping("/{id}")
    public Jogadores updateJogador (@RequestParam Long id,
                                  @RequestBody Jogadores jogador){
        return jogador;
    }

}
