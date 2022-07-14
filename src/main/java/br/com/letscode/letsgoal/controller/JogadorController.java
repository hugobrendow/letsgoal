package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.service.JogadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    final JogadorService jogadorService;

    @GetMapping
    public List<Jogador> findAll() {

        return jogadorService.findAll();
    }
    @PostMapping
    public Jogador saveJogador(@RequestBody Jogador jogador){
        return jogadorService.savejogador(jogador);
    }

    @GetMapping("/{id}")
    public Jogador findById(@PathVariable Long id){
        return jogadorService.findById(id);

    }@PutMapping("/{id}")
    public Jogador updateJogador(@PathVariable Long id,
                                           @RequestBody Jogador jogador) {
        return jogador;
    }



}
