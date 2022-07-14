package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.model.Partida;
import br.com.letscode.letsgoal.repository.PartidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class PartidaServiceImp implements PartidaService{
    private final PartidaRepository partidaRepository;

    public List<Partida> findAll() {
        return (List<Partida>) partidaRepository.findAll();
    }

    public Partida savePartida(Partida partida) {
        return partidaRepository.save(partida);
    }

    public Partida findByClube(String nomeClube) {
        return null;
    }

    public List<Partida> findByRodada(Long rodada) {
        return null;
    }

    public List<Partida> findByNextRodada(LocalDate today) {
        return null;
    }
}
