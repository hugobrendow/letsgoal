package br.com.letscode.letsgoal.domain.services.interfaces;

import br.com.letscode.letsgoal.domain.dto.JogadorDto;
import br.com.letscode.letsgoal.domain.models.Jogador;

import java.util.List;

public interface JogadorService {

    List<Jogador> findAll();
    Jogador findById(Long id);
    Jogador save(JogadorDto request);
    Jogador update(Long id, JogadorDto request);
}
