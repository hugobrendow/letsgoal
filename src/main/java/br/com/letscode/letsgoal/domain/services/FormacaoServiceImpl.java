package br.com.letscode.letsgoal.domain.services;

import br.com.letscode.letsgoal.domain.models.Formacao;
import br.com.letscode.letsgoal.domain.repositories.FormacaoRepository;
import br.com.letscode.letsgoal.domain.services.interfaces.FormacaoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormacaoServiceImpl implements FormacaoService {

    private final FormacaoRepository repository;

    public FormacaoServiceImpl(FormacaoRepository repository) {
        this.repository = repository;
    }

    public List<Formacao> findAll(){
        return (List<Formacao>) repository.findAll();
    }

    public Optional<Formacao> findById(Long id){
        return repository.findById(id);
    }

    public Formacao save(Formacao entity){
        return repository.save(entity);
    }
}
