package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.entity.Patrocinador;
import br.com.letscode.letsgoal.service.PatrocinadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/patrocinadores")
public class PatrocinadorController {
    final PatrocinadorService patrocinadorService;


    @GetMapping
    public List<Patrocinador> findAll() {
       return patrocinadorService.findAll();
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
