package br.com.letscode.letsgoal.controller;


import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.service.EscudoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/escudos")
public class EscudoController {

    final EscudoService escudoService;

    public EscudoController(EscudoService escudoService){
        this.escudoService = escudoService;
    }

    @GetMapping
    public List<Escudo> findAll(){
        return escudoService.findAll();
    }

    @GetMapping("/{id}")
    public Escudo findById(@PathVariable Long id){
        return escudoService.findById(id);
    }

    @PostMapping
    public Escudo saveEscudo(@RequestBody Escudo escudo){
        return escudoService.saveEscudo(escudo);
    }

    @PutMapping("/{id}")
    public Escudo updateEscudo(@PathVariable Long id, @RequestBody Escudo escudo) {
        return escudo;
    }


}
