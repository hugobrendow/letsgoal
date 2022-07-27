package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.ObjectNotFoundException;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.repository.FormacaoRepository;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;
import java.util.Optional;

@Service
public class FormacaoService {

    private final FormacaoRepository formacaoRepository;

    public FormacaoService(FormacaoRepository formacaoRepository) {
        this.formacaoRepository = formacaoRepository;
    }

    public List<Formacao> salvarFormacoes(List<Formacao> formacoes) {

        return formacaoRepository.saveAll(formacoes);
    }

    public Formacao salvarFormacao(Formacao formacao) {

        return formacaoRepository.save(formacao);
    }

    public Formacao atualizar(Formacao formacao, Long id) {

        buscaPorId(id);
        formacao.setId(id);
        return formacaoRepository.save(formacao);
    }

    public Formacao buscaPorId(Long id) {

        return formacaoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
    }

    public List<Formacao> listar() {

        return formacaoRepository.findAll();
    }
}
