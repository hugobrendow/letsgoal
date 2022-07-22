package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.DadoExistenteException;
import br.com.letscode.letsgoal.exception.FormacaoNotFoundException;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.repository.FormacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FormacaoServiceImp implements FormacaoService{

    private final FormacaoRepository formacaoRepository;

    @Override
    public Formacao saveFormacao(Formacao formacao) {
        return formacaoRepository.save(formacao);
    }

    @Override
    public List<Formacao> findAll() {
        return formacaoRepository.findAll();
    }

    @Override
    public Formacao finfById(Long id) {
        Formacao formacao = formacaoRepository
                .findById(id)
                .orElseThrow(() -> new FormacaoNotFoundException());
        return formacao;
    }
}
