package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.DTO.FormacaoDTO;
import br.com.letscode.letsgoal.exception.FormacaoNotFoundException;
import br.com.letscode.letsgoal.exception.PatrocinadorNotFoundException;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.repository.FormacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FormacaoService {

    final FormacaoRepository formacaoRepository;

    @Autowired
    final ModelMapper modelMapper;


    public FormacaoService(FormacaoRepository formacaoRepository, ModelMapper modelMapper) {
        this.formacaoRepository = formacaoRepository;
        this.modelMapper = modelMapper;
    }

    public FormacaoDTO saveFormacao(FormacaoDTO formacaoDTO) {
        var formacaoEntity = modelMapper.map(formacaoDTO, Formacao.class);
        return Stream.of(formacaoRepository.save(formacaoEntity))
                .map(formacao -> modelMapper.map(formacao, FormacaoDTO.class))
                .findFirst()
                .orElseThrow(() -> new RuntimeException());

    }

    public List<FormacaoDTO> findAll() {
        return Stream.of(formacaoRepository.findAll())
                .map(formacao-> modelMapper.map(formacao, FormacaoDTO.class))
                .collect(Collectors.toList());
    }

    public FormacaoDTO findById(Long id) {
        return Stream.of(formacaoRepository.findAll())
                .map(formacao-> modelMapper.map(formacao, FormacaoDTO.class))
                .findFirst()
                .orElseThrow(() -> new FormacaoNotFoundException());
    }

}
