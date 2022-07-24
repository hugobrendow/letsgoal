package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.repository.JogadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JogadorService {
    private JogadorRepository jogadorRepository;

    public List<Jogador> salvarJogadores(List<Jogador> jogadores) {
        return jogadorRepository.saveAll(jogadores);
    }

    public List<Jogador> listar() {
        return jogadorRepository.findAll();
    }
}
