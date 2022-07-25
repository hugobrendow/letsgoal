package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.JogadorNotFoundException;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.repository.JogadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JogadorService {
    private JogadorRepository jogadorRepository;

    public Jogador saveJogador(Jogador jogador){
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> salvarJogadores(List<Jogador> jogadores) {
        return jogadorRepository.saveAll(jogadores);
    }

    public List<Jogador> listar() {
        return jogadorRepository.findAll();
    }

    public Jogador findById(Long id){
        Jogador jogador = jogadorRepository
                .findById(id)
                .orElseThrow(() -> new JogadorNotFoundException());
        return jogador;
    }
}
