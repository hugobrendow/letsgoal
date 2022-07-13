package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.service.PatrocinadorService;
import br.com.letscode.letsgoal.service.PatrocinadorServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patrocinadores")
@AllArgsConstructor
public class PatrocinadorController {
    private PatrocinadorService patrocinadorService;

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
        return patrocinadorService.updatePatrocinador(id,patrocinador);
    }

}
