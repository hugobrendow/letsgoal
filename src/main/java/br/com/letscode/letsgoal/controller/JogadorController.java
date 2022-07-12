package br.com.letscode.letsgoal.controller;


import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public List<Jogador> findAllPlayers(){
        return jogadorService.findAll();
    }

    @GetMapping("/{id}")
    public Jogador findPlayerById(@PathVariable Long id){
        return jogadorService.findById(id);
    }

    @PostMapping
    public Jogador savePlayer(@RequestBody Jogador jogador){

        return jogadorService.saveJogador(jogador);
    }

    @PutMapping("/{id}")
    public Jogador updatePlayer(@PathVariable Long id, @RequestBody Jogador jogador){
        return jogador;
    }


}
