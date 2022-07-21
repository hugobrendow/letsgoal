package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.exception.PatrocinadorNotFoundException;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.service.PatrocinadorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patrocinadores")
public class PatrocinadorController {
    private PatrocinadorService patrocinadorService;

    public PatrocinadorController(PatrocinadorService patrocinadorService) {
        this.patrocinadorService = patrocinadorService;
    }

    @GetMapping
    public List<Patrocinador> findAll() {
        List<Patrocinador> patrocinadores = patrocinadorService.findAll();
        return patrocinadores;
    }

    @PostMapping
    public Patrocinador savePatrocinador(@RequestBody Patrocinador patrocinador) {
        return patrocinadorService.savePatrocinador(patrocinador);
    }

    @GetMapping("/{id}")
    public Patrocinador findById(@PathVariable Long id) {
        return patrocinadorService.findById(id);
    }

    @PutMapping("/{id}")
    public Patrocinador updatePatrocinador(@PathVariable Long id,
                                           @RequestBody Patrocinador patrocinador) {
        return patrocinador;
    }

}
