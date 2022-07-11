package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Partida;
import java.util.Collections;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    @GetMapping
    public List<Partida> findAll() {
        return Collections.emptyList();
    }

    @PostMapping
    public Partida savePartida(@RequestBody Partida partida) {
        return partida;
    }

    @GetMapping("/{id}")
    public Partida findById(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/{id}")
    public Partida updatePartida(@PathVariable Long id,
                                 @RequestBody Partida partida) {
        return partida;
    }

}
