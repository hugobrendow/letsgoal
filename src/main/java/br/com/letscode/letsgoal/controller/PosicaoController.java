package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.entity.Posicao;
import br.com.letscode.letsgoal.service.PosicaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posicao")
public class PosicaoController {
    final PosicaoService posicaoService;


    @GetMapping
    public List<Posicao> findAll() {
        return posicaoService.findAll();
    }

    @PostMapping
    public Posicao savePosicao(@RequestBody Posicao posicao) {
        return posicaoService.savePosicao(posicao);
    }
}
