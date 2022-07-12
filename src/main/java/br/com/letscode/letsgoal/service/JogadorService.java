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

    final JogadorRepository jogadorRepository;

    public Jogador saveJogador(Jogador jogador){
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> findAll(){
        return (List<Jogador>) jogadorRepository.findAll();
    }

    public Jogador findById(Long id){
        Jogador jogador = jogadorRepository
                .findById(id)
                .orElseThrow(() -> new JogadorNotFoundException());
        return jogador;
    }

}
