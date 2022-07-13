package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.service.PatrocinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patrocinadores")
public class PatrocinadorController {

    @Autowired
    private PatrocinadorService service;

    @GetMapping
    public List<Patrocinador> listar(){
        return service.findAll();
    }

    @PostMapping
    public Patrocinador savePatrocinador(@RequestBody Patrocinador patrocinador){
        return service.save(patrocinador);
    }

    @GetMapping("/{id}")
    public Patrocinador getPatrocinadorById(@PathVariable Long id){
        Optional<Patrocinador> patrocinador = service.findById(id);
        if (patrocinador.isEmpty()){
            throw new RuntimeException();
        }
        return patrocinador.get();
    }

    @PutMapping("/{id}")
    public Patrocinador updatePatrocinador(@PathVariable Long id,
                                           @RequestBody Patrocinador patrocinador){
        return service.update(id, patrocinador);
    }

}
