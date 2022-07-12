package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Escudo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escudos")
public class EscudoController {
    @GetMapping
    public List<Escudo> findAll() {
        Escudo escudo = new Escudo(1L, "60x60", "45x45", "30x30");
        return List.of(escudo);
    }

    @PostMapping
    public Escudo saveEscudo(@RequestBody Escudo escudo) {
        return escudo;
    }

    @GetMapping("/{id}")
    public Escudo findById(@PathVariable Long id) {
        return new Escudo(id, "60x60", "45x45",  "30x30");
    }

    @PutMapping("/{id}")
    public Escudo updateEscudo(@PathVariable Long id, @RequestBody Escudo escudo) {
        return escudo;
    }
}
