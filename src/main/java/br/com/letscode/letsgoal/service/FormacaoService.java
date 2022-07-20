package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.dto.FormacaoDTOResponse;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.repositories.FormacaoRepository;
import br.com.letscode.letsgoal.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormacaoService {

    private final FormacaoRepository formacaoRepository;

    public FormacaoService(FormacaoRepository formacaoRepository) {
        this.formacaoRepository = formacaoRepository;
    }

    public List<FormacaoDTOResponse> findAll(){
        List<Formacao> all = formacaoRepository.findAll();
        return all.stream().map(formacao -> {
            FormacaoDTOResponse response = new FormacaoDTOResponse();
            BeanUtils.copyProperties(formacao, response);
            return response;
        }).collect(Collectors.toList());
    }

    public FormacaoDTOResponse findById(Long id){
        Formacao byId = formacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        FormacaoDTOResponse formacaoDTOResponse = new FormacaoDTOResponse();
        BeanUtils.copyProperties(byId, formacaoDTOResponse);
        return formacaoDTOResponse;
    }

}
