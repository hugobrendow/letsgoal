package br.com.letscode.letsgoal.domain.services;

import br.com.letscode.letsgoal.domain.dto.FormacaoDto;
import br.com.letscode.letsgoal.domain.models.Formacao;
import br.com.letscode.letsgoal.domain.repositories.FormacaoRepository;
import br.com.letscode.letsgoal.domain.services.interfaces.FormacaoService;
import br.com.letscode.letsgoal.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormacaoServiceImpl implements FormacaoService {

    private final FormacaoRepository repository;

    public FormacaoServiceImpl(FormacaoRepository repository) {
        this.repository = repository;
    }

    public List<Formacao> findAll(){
        return (List<Formacao>) repository.findAll();
    }

    public Formacao findById(Long id){
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Formacao save(FormacaoDto request){
        Formacao entity = new Formacao();
        BeanUtils.copyProperties(request, entity);
        return repository.save(entity);
    }
}
