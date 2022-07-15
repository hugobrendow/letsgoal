package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.PartidaNotFoundException;
import br.com.letscode.letsgoal.model.Partida;
import br.com.letscode.letsgoal.repository.PartidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PartidaService {
    final PartidaRepository partidaRepository;
    public List<Partida> findAll() {
        return (List<Partida>) partidaRepository.findAll();
    }

    public Partida findById(Long id) {
        return partidaRepository
                .findById(id)
                .orElseThrow(PartidaNotFoundException::new);
    }

    public Partida savePartida(Partida partida) {
        return partidaRepository.save(partida);
    }
}
