package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.model.LetsClube;

import java.util.List;

public interface LetsClubeService {
    LetsClube saveLetsClub(LetsClube letsClube);
    List<LetsClube> findAll();
    LetsClube findByID(Long id);
    LetsClube updateLetsClub(Long id, LetsClube letsClube);


}
