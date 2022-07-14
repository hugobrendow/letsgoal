package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.model.Posicao;

import java.util.List;

public interface PosicaoService {
    Posicao savePosicao(Posicao posicao);
    List<Posicao> findAll();
    Posicao findById(Long id);
}
