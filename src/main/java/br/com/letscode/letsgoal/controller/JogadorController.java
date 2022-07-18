package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.service.JogadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public List<Jogador> findAll() {
        return jogadorService.findAll();
    }

    @PostMapping
    public Jogador saveJogador(@RequestBody Jogador jogador) {
        return jogadorService.saveJogador(jogador);
    }

    @GetMapping("/{id}")
    public Jogador findById(@PathVariable Long id) {
        return jogadorService.findById(id);
    }

    @PutMapping("/{id}")
    public Jogador updateJogador(@PathVariable Long id, @RequestBody Jogador jogador) {
        return jogadorService.updateJogador(id, jogador);
    }
}
