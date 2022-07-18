package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.DTO.FormacaoDTO.FormacaoRequestDTO;
import br.com.letscode.letsgoal.DTO.FormacaoDTO.FormacaoResponseDTO;
import br.com.letscode.letsgoal.Util.Conversor;
import br.com.letscode.letsgoal.exception.FormacaoNotFoundException;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.repository.FormacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FormacaoService {
    @Autowired
    final FormacaoRepository formacaoRepository;

    @Autowired
    final ModelMapper modelMapper;


    public FormacaoService(FormacaoRepository formacaoRepository, ModelMapper modelMapper) {
        this.formacaoRepository = formacaoRepository;
        this.modelMapper = modelMapper;
    }

    public Formacao saveFormacao(FormacaoRequestDTO formacaoRequestDTO) {
        var formacaoEntity = modelMapper.map(formacaoRequestDTO, Formacao.class);
        return formacaoRepository.save(formacaoEntity);
    }

    public List<Formacao> findAll() {
        return Conversor.iterableToStream(formacaoRepository.findAll())
                .collect(Collectors.toList());
    }

    public Formacao findById(Long id) {
        return formacaoRepository.findById(id).orElseThrow(() -> new FormacaoNotFoundException("Não foi encontrada nenhuma formação com esse ID"));
    }

    public Formacao atualizar(Long id, FormacaoRequestDTO formacaoRequestDTO){
        var formacao = findById(id);
        BeanUtils.copyProperties(formacaoRequestDTO, formacao);
        return formacaoRepository.save(formacao);
    }

    public FormacaoResponseDTO conversorEntidadeParaDTO(Formacao formacao){
        return modelMapper.map(formacao, FormacaoResponseDTO.class);
    }

    public List<FormacaoResponseDTO> conversorEntidadeParaDTO(List<Formacao> formacaos){
        return formacaos.stream()
                .map(formacao -> modelMapper.map(formacao, FormacaoResponseDTO.class))
                .collect(Collectors.toList());
    }


}
