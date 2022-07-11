package br.com.letscode.letsgoal.controller;


import br.com.letscode.letsgoal.model.Jogador;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @GetMapping
    public List<Jogador> findAllPlayers(){
        Jogador jogador = new Jogador(1L,"Provável", new BigDecimal(15000),6.58,58,"Luizão","Luiz Augusto de Oliveira","http://link");
        List<Jogador> jogadores = List.of(jogador);
        return jogadores;
    }

    @GetMapping("/{id}")
    public Jogador findPlayerById(@PathVariable Long id){
        Jogador jogador = new Jogador(id,"Provável", new BigDecimal(15000),6.58,58,"Luizão","Luiz Augusto de Oliveira","http://link");
        return jogador;
    }

    @PostMapping
    public Jogador savePlayer(@RequestBody Jogador jogador){
        return jogador;
    }

    @PutMapping("/{id}")
    public Jogador updatePlayer(@PathVariable Long id, @RequestBody Jogador jogador){
        return jogador;
    }


}
