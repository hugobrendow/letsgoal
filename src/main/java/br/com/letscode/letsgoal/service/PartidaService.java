package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.EscudoNotFoundException;
import br.com.letscode.letsgoal.exception.PartidaNotFoundException;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.model.Partida;
import br.com.letscode.letsgoal.repository.PartidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidaService {
    private final PartidaRepository partidaRepository;

    public PartidaService(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    public Partida savePartida(Partida partida) {
        return partidaRepository.save(partida);
    }

    public List<Partida> findAll() {
        return (List<Partida>) partidaRepository.findAll();
    }

    public Partida findById(Long id) {
        return partidaRepository
                .findById(id)
                .orElseThrow(PartidaNotFoundException::new);
    }

    public Partida updatePartida(Long id, Partida partidaAtualizada) {
        Partida partidaAtual = partidaRepository
                .findById(id)
                .orElseThrow(EscudoNotFoundException::new);
        partidaAtualizada
                .setId(partidaAtual
                        .getId());
        return partidaRepository.save(partidaAtualizada);
    }
}
