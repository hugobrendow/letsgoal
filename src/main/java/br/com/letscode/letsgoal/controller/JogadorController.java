package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    JogadorService jogadorService;

    @GetMapping
    public List<Jogador> findAll() {
        return jogadorService.findAll();
    }

    @PostMapping
    public Jogador saveJogador(@RequestBody Jogador jogador) {
        // SERVIÇO - REGRA DE NEGÓCIO
        return jogador;
    }

    @GetMapping("/{id}")
    public Jogador findById(@PathVariable Long id) {
        Jogador jogador = new Jogador();
        jogador.setNome("JOSE");
        jogador.setId(1l);
        return jogador;
    }
}
