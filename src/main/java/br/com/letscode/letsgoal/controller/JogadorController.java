package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Jogador;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    @GetMapping
    public List<Jogador> findAll() {
        Jogador jogador = new Jogador(1L,"liberado", 10d, 6.9, 30, "Juninho", "João Junior", "foto");
        return List.of(jogador);
    }

    @PostMapping
    public Jogador saveJogador(@RequestBody Jogador jogador) {
        return jogador;
    }

    @GetMapping("/{id}")
    public Jogador findById(@PathVariable Long id) {
        return new Jogador(id, "suspenso", 7d, 5.5, 29, "Zezinho", "José", "foto" );
    }

    @PutMapping("/{id}")
    public Jogador updateJogador(@PathVariable Long id, @RequestBody Jogador jogador) {
        return jogador;
    }
}
