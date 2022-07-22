package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.ClienteExistenteException;
import br.com.letscode.letsgoal.exception.JogadorNotFoundException;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.repository.JogadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JogadorService {
    final JogadorRepository jogadorRepository;

    public Jogador save(Jogador jogador) {
        Optional<Jogador> optionalJogador = jogadorRepository.findByIdOrNome(jogador.getId(),jogador.getNome());
        optionalJogador.ifPresent(obj -> { throw new ClienteExistenteException(); });
        return jogadorRepository.save(jogador);
    }
    public List<Jogador> findAll() {
        return  jogadorRepository.findAll();
    }

    public Jogador update(Jogador jogador, Long id) {
        jogadorRepository.findById(id).orElseThrow(JogadorNotFoundException::new);
        jogador.setId(id);
        return jogadorRepository.save(jogador);
    }
    public Jogador findById(Long id) {
        return jogadorRepository
                .findById(id)
                .orElseThrow(JogadorNotFoundException::new);
    }
}
