package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.service.JogadorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
@AllArgsConstructor
public class JogadorController {
    private JogadorService jogadorService;

    @PostMapping
    public Jogador saveJogador(@RequestBody Jogador jogador){
        return jogadorService.saveJogador(jogador);
    }
    @GetMapping
    public List<Jogador> findAll(){
        return jogadorService.findAll();
    }
    @GetMapping("/{id}")
    public Jogador findById(@PathVariable Long id){
        return jogadorService.findByID(id);
    }
    @PutMapping("/{id}")
    public Jogador updateJogador(@PathVariable Long id, @RequestBody Jogador jogador){
        return jogadorService.updateJogador(id, jogador);
    }


}
