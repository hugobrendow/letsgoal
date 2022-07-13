package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.model.Patrocinador;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/letsclubes")
public class LetsClubeController {

    @GetMapping
    public List<LetsClube> findAll(){
        Patrocinador patrocinador = new Patrocinador(1L,"CI&T","http://www.ciandt.com","http://marca","CI&T");
        Jogador jogador = new Jogador(1L, "Provável",11.16d, 5.45d, 13, "Cássioooo", "Cássio", "foto");
        LetsClube letsClube = new LetsClube(1L,"LetsGoCorinthians","5-4-1", Arrays.asList(patrocinador),Arrays.asList(jogador));
        return List.of(letsClube);
    }

    @GetMapping
    public LetsClube saveLetsClube(@RequestBody LetsClube letsClube) {

        return letsClube;
    }
    @GetMapping("/{id}")
    public LetsClube findById(@RequestParam Long id){
        Patrocinador patrocinador = new Patrocinador(1L,"CI&T","http://www.ciandt.com","http://marca","CI&T");
        Jogador jogador = new Jogador(1L, "Provável",11.16d, 5.45d, 13, "Cássioooo", "Cássio", "foto");
        LetsClube letsClube = new LetsClube(1L,"LetsGoCorinthians","5-4-1", Arrays.asList(patrocinador),Arrays.asList(jogador));
        return letsClube;
    }

    @PutMapping("/{id}")
    public LetsClube updateLetsClube(@RequestParam Long id,
                                     @RequestBody LetsClube letsClube){
        return letsClube;
    }

}
