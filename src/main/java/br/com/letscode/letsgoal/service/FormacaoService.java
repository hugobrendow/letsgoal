package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.model.Formacao;

import java.util.List;

public interface FormacaoService {
    Formacao saveFormacao(Formacao formacao);
    List<Formacao> findAll();
    Formacao finfById(Long id);
}
