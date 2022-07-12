package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Escudo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escudos")
public class EscudoController {

    @GetMapping
    public List<Escudo> findAll() {
        Escudo escudo = new Escudo(1L, "Escudo", "Descrição", "URL", "Marca");
        List<Escudo> escudos = List.of(escudo);
        return escudos;
    }

    @PostMapping
    public Escudo saveEscudo(@RequestBody Escudo escudo) {return escudo;}

    @GetMapping("/{id}")
    public Escudo findById(@PathVariable Long id) {
        return new Escudo (id, "Escudo", "Descrição", "URL", "Marca");
    }

    @PostMapping("/{id}")
    public Escudo updateEscudo(@PathVariable Long id,
                               @RequestBody Escudo escudo) {
        return escudo;
    }
}
