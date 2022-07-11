package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Jogador;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @GetMapping
    public List<Jogador> findAll() {
        Jogador jogador = new Jogador();
        jogador.setNome("JOAO");
        Jogador jogador1 = new Jogador();
        jogador1.setNome("PEDRO");
        return Arrays.asList(jogador, jogador1);
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
