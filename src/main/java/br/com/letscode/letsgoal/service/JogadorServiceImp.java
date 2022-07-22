package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.DadoExistenteException;
import br.com.letscode.letsgoal.exception.JogadorNotFoundException;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.repository.JogadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JogadorServiceImp implements JogadorService{
    private final JogadorRepository jogadorRepository;

    public Jogador saveJogador(Jogador jogador) {
        Optional<Jogador> optionalJogador = jogadorRepository.findByNomeOrApelido(jogador.getNome(), jogador.getApelido());
        optionalJogador.ifPresent(obj -> {throw new DadoExistenteException();});
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> findAll() {
        return jogadorRepository.findAll();
    }

    public Jogador findByID(Long id) {
        return jogadorRepository
                .findById(id)
                .orElseThrow(() -> new JogadorNotFoundException());
    }

    public Jogador updateJogador(Long id, Jogador jogador) {
        jogadorRepository
                .findById(id)
                .orElseThrow(() ->new JogadorNotFoundException());

        jogador.setId(id);
        return jogadorRepository.save(jogador);

    }
}
