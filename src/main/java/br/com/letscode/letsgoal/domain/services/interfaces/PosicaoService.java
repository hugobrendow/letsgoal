package br.com.letscode.letsgoal.domain.services.interfaces;

import br.com.letscode.letsgoal.domain.models.Posicao;

import java.util.Optional;

public interface PosicaoService {
    Posicao savePosicao(Posicao entity);
    Iterable<Posicao> findAll();
    Optional<Posicao> findById(Long id);

}
