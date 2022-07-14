package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.service.EscudoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/escudos")
public class EscudoController {
    final EscudoService escudoService;

    @GetMapping
    public List<Escudo> findAll() {
        return escudoService.findAll();
    }

    @PostMapping
    public Escudo saveEscudo(@RequestBody Escudo escudo) {
        return escudoService.saveEscudo(escudo);
    }

    @GetMapping("/{id}")
    public Escudo findById(@PathVariable Long id) {

        return escudoService.findById(id);
    }

    public Escudo updateEscudo(@PathVariable Long id, @RequestBody Escudo escudo) {
        return escudo;
    }
}
