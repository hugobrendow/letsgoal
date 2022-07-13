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
        Escudo escudo = new Escudo(1L,"60x60","45x45","30x30");
        Clube clube = new Clube(1L,"Sport Club LetsGoCorinthians", Arrays.asList(escudo),"Vai Corinthians");
        return List.of(clube);
    }

    @GetMapping
    public Clube saveClube(@RequestBody Clube clube){
        return clube;
    }

    @GetMapping("/{id}")
    public Clube findById(@RequestParam Long id){
        Escudo escudo = new Escudo(1L,"60x60","45x45","30x30");
        Clube clube = new Clube(1L,"Sport Club LetsGoCorinthians", Arrays.asList(escudo),"Vai Corinthians");
        return clube;
    }

    @PutMapping("/{id}")
    public Clube updateClube(@RequestParam Long id,
                             @RequestBody Clube clube){
        return clube;
    }
}
