package br.com.letscode.letsgoal.domain.services.interfaces;

import br.com.letscode.letsgoal.domain.models.Posicao;

import java.util.List;

public interface PosicaoService {
    List<Posicao> findAll();
    Posicao findById(Long id);
    Posicao findByAbreviacao(String abreviacao);
    Posicao save(Posicao posicao);
    List<Posicao> saveAll(List<Posicao> posicaos);
}
