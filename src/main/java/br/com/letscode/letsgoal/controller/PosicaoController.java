package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Posicao;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/posicoes")
public class PosicaoController {

    @GetMapping
    public List<Posicao> findAll() {
        return Collections.emptyList();
    }

    @PostMapping
    public Posicao savePosicao(@RequestBody Posicao posicao) {
        return posicao;
    }

    @GetMapping("/{id}")
    public Posicao getById(@PathVariable Long id) {
        return null;
    }
}
