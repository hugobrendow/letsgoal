package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.ClienteExistenteException;
import br.com.letscode.letsgoal.exception.FormacaoNotFoundException;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.repository.FormacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FormacaoService {
    final FormacaoRepository formacaoRepository;

    public Formacao save(Formacao formacao) {
        Optional<Formacao> optionalFormacao=formacaoRepository.findById(formacao.getId());
        optionalFormacao.ifPresent(obj -> { throw new ClienteExistenteException(); });
        return formacaoRepository.save(formacao);
    }

    public List<Formacao> findAll() {
        return  formacaoRepository.findAll();
    }

    public Formacao findById(Long id) {
        return formacaoRepository
                .findById(id)
                .orElseThrow(FormacaoNotFoundException::new);
    }
}
