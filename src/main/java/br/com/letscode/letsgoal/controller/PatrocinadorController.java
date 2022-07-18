package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.service.PatrocinadorService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patrocinadores")
public class PatrocinadorController {
    private final PatrocinadorService patrocinadorService;


    public PatrocinadorController(PatrocinadorService patrocinadorService) {
        this.patrocinadorService = patrocinadorService;
    }

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
        return patrocinadorService.findByid(id);
    }

    @PutMapping("/{id}")
    public Patrocinador updatePatrocinador(@PathVariable Long id,
                                           @RequestBody Patrocinador patrocinador) {
        return patrocinador;
    }

}
