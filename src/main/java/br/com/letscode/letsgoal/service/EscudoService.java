package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.model.Escudo;

import java.util.List;

public interface EscudoService {
    Escudo saveEscudo(Escudo escudo);
    List<Escudo> findAll();
    Escudo findByID(Long id);
    Escudo updateEscudo(Long id, Escudo escudo);
}
