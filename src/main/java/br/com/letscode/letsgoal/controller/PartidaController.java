package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.model.Partida;
import br.com.letscode.letsgoal.service.PartidaService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    private final PartidaService partidaService;

    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @GetMapping
    public List<Partida> findAll() {
        return partidaService.findAll();
    }


    @PostMapping
    public Partida savePartida(@RequestBody Partida partida) {
        return partidaService.savePartida(partida);
    }

    @GetMapping("/{id}")
    public Partida findById(@PathVariable Long id) {
        return partidaService.findById(id);
    }

    @PutMapping("/{id}")
    public Partida updatePartida(@PathVariable Long id,
                                           @RequestBody Partida partida) {
        return partidaService.updatePartida(id, partida);
    }

    // fazer buscarProximaPartidaPorClube()
    // fazer buscarPartidasPorRodada()
    // fazer buscarPartidasDaProximaRodada()
}
