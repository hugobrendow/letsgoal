package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.model.Patrocinador;

import java.util.List;

public interface PatrocinadorService {
    Patrocinador savePatrocinador(Patrocinador patrocinador);
    List<Patrocinador> findAll();
    Patrocinador findById(Long id);
    Patrocinador updatePatrocinador(Long id, Patrocinador patrocinador);

}
