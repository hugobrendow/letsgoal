package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.model.Posicao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posicoes")
public class PosicaoController {

    @GetMapping
    public List<Posicao> findAll() {
        Posicao posicao = new Posicao(1L, "Goleiro");
        return List.of(posicao);
    }

    @PostMapping
    public Posicao savePosicao(@RequestBody Posicao posicao) {
        return posicao;
    }

    @GetMapping("/{id}")
    public Posicao getById(@PathVariable Long id) {
        Posicao posicao = new Posicao(1L, "Goleiro");
        return posicao;
    }

    @PutMapping("/{id}")
    public Posicao updatePosicao(@PathVariable Long id,
                                           @RequestBody Posicao posicao) {
        return posicao;
    }
}
