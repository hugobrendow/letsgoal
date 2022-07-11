package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Jogador;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @GetMapping
    List<Jogador> findAll(){
        Jogador jogador = new Jogador();
        return List.of(jogador);
    }

    @GetMapping("/{id}")
    List<Jogador> findById(@PathVariable Long id){
        Jogador jogador = new Jogador();
        return List.of(jogador);
    }

    @PostMapping
    public Jogador saveJogador(@RequestBody Jogador jogador){
        //Insere jogador no banco de dados
        return jogador;
    }

    @PutMapping("/{id}")
    public Jogador updateJogador(@PathVariable Long id,
                                 @RequestBody Jogador jogador) {
        //Atualiza jogador no banco de dados
        return jogador;
    }

    @DeleteMapping("/{id}")
    public Jogador deleteJogador(@PathVariable Long id,
                                 @RequestBody Jogador jogador) {
        //Deleta jogador do banco de dados
        return jogador;
    }

}
