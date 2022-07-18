package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.service.PosicaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posicoes")
public class PosicaoController {
    private final PosicaoService posicaoService;

    public PosicaoController(PosicaoService posicaoService) {
        this.posicaoService = posicaoService;
    }

    @GetMapping
    public List<Posicao> findAll() {
        return posicaoService.findAll();
    }

    @PostMapping
    public Posicao savePosicao(@RequestBody Posicao posicao) {
        return posicaoService.savePosicao(posicao);
    }

    @GetMapping("/{id}")
    public Posicao findById(@PathVariable Long id) {
        return posicaoService.findById(id);
    }
}
