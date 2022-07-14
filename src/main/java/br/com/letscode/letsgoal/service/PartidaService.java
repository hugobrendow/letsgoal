package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.model.Partida;

import java.time.LocalDate;
import java.util.List;

public interface PartidaService {
    List<Partida> findAll();
    Partida savePartida(Partida partida);
    Partida findByClube(String clube);
    List<Partida> findByRodada(Long rodada);
    List<Partida> findByNextRodada(LocalDate today);
}
