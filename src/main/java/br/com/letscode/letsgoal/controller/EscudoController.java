package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.service.EscudoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escudos")
@AllArgsConstructor
public class EscudoController {

    private final EscudoService escudoService;


    @PostMapping
    public Escudo saveEscudo(@RequestBody Escudo escudo) {
        return escudoService.saveEscudo(escudo);
    }

    @GetMapping
    public List<Escudo> findAll(){
        return escudoService.findAll();
    }

    @GetMapping("/{id}")
    public Escudo findById(@PathVariable Long id){
        return escudoService.findByID(id);
    }

    @PutMapping("/{id}")
    public Escudo updateEscudo(@PathVariable Long id, @RequestBody Escudo escudo){
        return escudoService.updateEscudo(id, escudo);
    }



}
