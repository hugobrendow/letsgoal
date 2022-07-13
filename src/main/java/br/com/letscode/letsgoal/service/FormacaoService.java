package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.repository.FormacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormacaoService {

    @Autowired
    private FormacaoRepository repository;

    public Optional<Formacao> findById(Long id){
        return repository.findById(id);
    }

    public List<Formacao> findAll(){
        return repository.findAll();
    }

    public Formacao save(Formacao formacao){
        return repository.save(formacao);
    }
}
