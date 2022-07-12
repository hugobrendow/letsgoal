package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.model.Partida;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {
    @GetMapping
    public List<Partida> findAll() {
        Clube clubeDaCasa = new Clube(1L, "Flamengo", "Fla", List.of(new Escudo()), "Flamengo");
        Clube clubeVisitante = new Clube(2L, "Fluminense", "Flu", List.of(new Escudo()), "Fluminense");
        Partida partida = new Partida(1L, clubeDaCasa, clubeVisitante, LocalDate.now(), "Maracanã", 3, 2, 2 );
        return List.of(partida);
    }


    @PostMapping
    public Partida savePartida(@RequestBody Partida partida) {
        return partida;
    }

    @GetMapping("/{id}")
    public Partida findById(@PathVariable Long id) {
        Clube clubeDaCasa = new Clube(1L, "Santos", "Sto", List.of(new Escudo()), "Santos");
        Clube clubeVisitante = new Clube(2L, "Plameiras", "Pal", List.of(new Escudo()), "Palemeiras");
        return new Partida(id, clubeDaCasa, clubeVisitante, LocalDate.now(), "Allianz Park", 5, 3, 1 );
    }

    @PutMapping("/{id}")
    public Partida updatePartida(@PathVariable Long id,
                                           @RequestBody Partida partida) {
        return partida;
    }

    // fazer buscarProximaPartidaPorClube()
    // fazer buscarPartidasPorRodada()
    // fazer buscarPartidasDaProximaRodada()
}
