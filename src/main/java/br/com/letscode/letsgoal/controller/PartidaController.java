package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Partida;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {
    @GetMapping
    public List<Partida> findAll() {
        Partida partida = new Partida();

        //REGRAS

        return Arrays.asList(partida);
    }

    @GetMapping("{/id}")
    public Partida findById(@PathVariable Long id){
        Partida partida = new Partida();

        //REGRAS

        return partida;
    }

    @PostMapping
    public Partida savePartida(@RequestBody Partida partida){

        //REGRAS

        return partida;
    }

    @PutMapping("{/id}")
    public Partida updatePartida(@PathVariable Long id, @RequestBody Partida partida){

        //REGRAS

        return partida;
    }

}
