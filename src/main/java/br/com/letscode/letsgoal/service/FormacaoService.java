package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.PosicaoNotFoundException;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.repository.FormacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormacaoService {
    private final FormacaoRepository formacaoRepository;

    public FormacaoService(FormacaoRepository formacaoRepository) {
        this.formacaoRepository = formacaoRepository;
    }

    public Formacao saveFormacao(Formacao formacao) {
        return formacaoRepository.save(formacao);
    }

    public List<Formacao> findAll() {
        return (List<Formacao>) formacaoRepository.findAll();
    }

    public Formacao findById(Long id) {
        return formacaoRepository
                .findById(id)
                .orElseThrow(PosicaoNotFoundException::new);
    }
}
