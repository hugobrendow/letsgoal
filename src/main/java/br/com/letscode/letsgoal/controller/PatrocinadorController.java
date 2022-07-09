package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Patrocinador;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patrocinadores")
public class PatrocinadorController {

    @GetMapping
    public List<Patrocinador> findAll() {
        Patrocinador patrocinador = new Patrocinador(1L, "Let's Code", "https://letscode.com.br", "https://letscode.com.br", "Let's Code");
        List<Patrocinador> patrocinadores = List.of(patrocinador);
        return patrocinadores;
    }

    @PostMapping
    public Patrocinador savePatrocinador(@RequestBody Patrocinador patrocinador) {
        return patrocinador;
    }

    @GetMapping("/{id}")
    public Patrocinador findById(@PathVariable Long id) {
        Patrocinador patrocinador = new Patrocinador(id, "Let's Code", "https://letscode.com.br", "https://letscode.com.br", "Let's Code");
        return patrocinador;
    }

    @PutMapping("/{id}")
    public Patrocinador updatePatrocinador(@PathVariable Long id,
                                           @RequestBody Patrocinador patrocinador) {
        return patrocinador;
    }

}
