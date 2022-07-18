package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.EscudoNotFoundException;
import br.com.letscode.letsgoal.exception.JogadorNotFoundException;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.repository.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {
    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public Jogador saveJogador(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> findAll() {
        return (List<Jogador>) jogadorRepository.findAll();
    }

    public Jogador findById(Long id) {
        return jogadorRepository
                .findById(id)
                .orElseThrow(JogadorNotFoundException::new);
    }

    public Jogador updateJogador(Long id, Jogador jogadorAtualizado) {
        Jogador jogadorAtual = jogadorRepository
                .findById(id)
                .orElseThrow(EscudoNotFoundException::new);
        jogadorAtualizado
                .setId(jogadorAtual
                        .getId());
        return jogadorRepository.save(jogadorAtualizado);
    }
}
