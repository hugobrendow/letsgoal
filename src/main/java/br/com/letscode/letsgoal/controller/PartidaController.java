package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Partida;
import br.com.letscode.letsgoal.service.PartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/partidas")
public class PartidaController {
    public PartidaService partidaService;
    @GetMapping
    public List<Partida> findAll() {
       return partidaService.findAll();

    }
    @PostMapping
    public Partida savePartida(@RequestBody Partida partida) {
        return
                partidaService.savePartida(partida);
    }
    @PutMapping("/{id}")
    public Partida updateResultadoPartida(@PathVariable Long id,
                                           @RequestBody Partida partida) {
        return partida;
    }

}
