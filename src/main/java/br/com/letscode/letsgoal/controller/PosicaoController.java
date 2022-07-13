package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.LetsClub;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.service.PosicaoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posicoes")
@AllArgsConstructor
public class PosicaoController {
    final PosicaoService posicaoService;

    @GetMapping()
    public List<Posicao> findALL(){
        return posicaoService.findAll();
    }
    @PostMapping()
    public Posicao savePosicao(@RequestBody Posicao posicao){
        return posicaoService.savePosicao(posicao);
    }
    @GetMapping("/{id}")
    public Posicao findById(@PathVariable Long id){
        return posicaoService.findById(id);
    }
}
