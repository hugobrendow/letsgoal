package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.ClienteExistenteException;
import br.com.letscode.letsgoal.exception.PartidaNotFoundException;
import br.com.letscode.letsgoal.model.Partida;
import br.com.letscode.letsgoal.repository.PartidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartidaService {
    private final PartidaRepository partidaRepository;

    public Partida save(Partida partida) {
        Optional<Partida> optionalPartida = partidaRepository.findById(partida.getId());
        optionalPartida.ifPresent(obj -> { throw new ClienteExistenteException(); });
        return partidaRepository.save(partida);
    }
    public List<Partida> findAll() {
        return partidaRepository.findAll();
    }
    public Partida findById(Long id) {
        return partidaRepository
                .findById(id)
                .orElseThrow(PartidaNotFoundException::new);
    }


}
