package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.FormacaoNotFoundException;
import br.com.letscode.letsgoal.entity.Formacao;
import br.com.letscode.letsgoal.repository.FormacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FormacaoService {
    final FormacaoRepository formacaoRepository;

    public Formacao saveFormacao(Formacao formacao) {
        return formacaoRepository.save(formacao);
    }

    public List<Formacao> findAll() {
        return (List<Formacao>) formacaoRepository.findAll();
    }

    public Formacao findById(Long id) {
        return formacaoRepository
                .findById(id)
                .orElseThrow(FormacaoNotFoundException::new);
    }
}
