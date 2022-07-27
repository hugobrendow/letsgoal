package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.model.Jogador;

import java.util.List;

public interface JogadorService {
    Jogador saveJogador(Jogador jogador);
    List<Jogador> findAll();
    Jogador findByID(Long id);
    Jogador updateJogador(Long id, Jogador jogador);

    List<Jogador> salvarJogadores(List<Jogador> jogadores);
}
