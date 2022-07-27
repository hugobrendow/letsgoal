package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.model.Clube;

import java.util.List;

public interface ClubeService {
    Clube saveClube(Clube clube);
    List<Clube> findAll();
    Clube findById(Long id);
    Clube updateClube(Long id, Clube clube);

    List<Clube> salvarClubes(List<Clube> clubes);
}
