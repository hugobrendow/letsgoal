package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Posicao;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/posicaos")
public class PosicaoController {
    @GetMapping
    public List<Posicao> findAll() {
        Posicao posicao = new Posicao();

        //REGRAS

        return Arrays.asList(posicao);
    }

    @GetMapping("{/id}")
    public Posicao findById(@PathVariable Long id){
        Posicao posicao = new Posicao();

        //REGRAS

        return posicao;
    }

    @PostMapping
    public Posicao savePosicao(@RequestBody Posicao posicao){

        //REGRAS

        return posicao;
    }

    @PutMapping("{/id}")
    public Posicao updatePosicao(@PathVariable Long id, @RequestBody Posicao posicao){

        //REGRAS

        return posicao;
    }

}

