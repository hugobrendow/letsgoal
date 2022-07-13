package br.com.letscode.letsgoal.domain.services.interfaces;

import br.com.letscode.letsgoal.domain.models.Patrocinador;

import java.util.List;
import java.util.Optional;

public interface PatrocinadorService {

    List<Patrocinador> findAll();
    Optional<Patrocinador> findById(Long id);
    Patrocinador save(Patrocinador entity);
}
