package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Escudo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/escudos")
public class EscudoController {

    @GetMapping
    public List<Escudo> findAll(){
        return Collections.emptyList();
    }

    @PostMapping
    public Escudo saveEscudo(@RequestBody Escudo escudo){
        return escudo;
    }

    @GetMapping("/{id}")
    public Escudo findById(@PathVariable Long id){
        return null;
    }

    @PutMapping("/{id}")
    public Escudo updateEscudo(@PathVariable Long id,
                               @RequestBody Escudo escudo){
        return escudo;
    }
}
