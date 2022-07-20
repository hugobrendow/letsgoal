package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Escudo;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    @GetMapping
    public List<Clube> findAll(){
        Escudo escudo = new Escudo(1L, "45x45");
        Clube clube = new Clube(1L, "Sport Club Clubinho", "SCC", Arrays.asList(escudo), "Clubinho");
        return List.of(clube);
    }

    @PostMapping
    public Clube saveClube(@RequestBody Clube clube){
        return clube;
    }

    @GetMapping("/{id}")
    public Clube findById(@PathVariable Long id){
        Escudo escudo = new Escudo(1L, "45x45");
        Clube clube = new Clube(1L, "Sport Club Clubinho", "SCC", Arrays.asList(escudo), "Clubinho");
        return clube;
    }

    @PutMapping("/{id}")
    public Clube updateClube(@PathVariable Long id,
                             @RequestBody Clube clube){
        return clube;
    }
}
