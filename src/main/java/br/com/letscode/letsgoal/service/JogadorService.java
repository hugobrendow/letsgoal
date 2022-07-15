package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.LetsClubeNotFoundException;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    final JogadorRepository jogadorRepository;

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
        Jogador jogador = jogadorRepository
                .findById(id)
                .orElseThrow(() -> new LetsClubeNotFoundException());
        return jogador;
    }

}
