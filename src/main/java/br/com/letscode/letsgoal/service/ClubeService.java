package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.DTO.ClubeDTO.ClubeRequestDTO;
import br.com.letscode.letsgoal.DTO.ClubeDTO.ClubeResponseDTO;
import br.com.letscode.letsgoal.DTO.FormacaoDTO.FormacaoRequestDTO;
import br.com.letscode.letsgoal.DTO.FormacaoDTO.FormacaoResponseDTO;
import br.com.letscode.letsgoal.exception.ClubeExistenteException;
import br.com.letscode.letsgoal.exception.ClubeNotFoundException;
import br.com.letscode.letsgoal.exception.FormacaoNotFoundException;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.repository.ClubeRepository;
import br.com.letscode.letsgoal.repository.FormacaoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Destination;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubeService {

    final ClubeRepository clubeRepository;
    final ModelMapper modelMapper;

    public ClubeService(ClubeRepository clubeRepository, ModelMapper modelMapper) {
        this.clubeRepository = clubeRepository;
        this.modelMapper = modelMapper;
    }

    public Clube saveClube(ClubeRequestDTO clubeRequestDTO) {
        clubeRepository.findByNomeDoClubeOrAbreviacao(clubeRequestDTO.getNomeDoClube(), clubeRequestDTO.getAbreviacao())
                .ifPresent(obj -> {throw new ClubeExistenteException("Clube com mesmo nome ou abreviação já existente"); });
        var clubeEntity = modelMapper.map(clubeRequestDTO, Clube.class);
        return clubeRepository.save(clubeEntity);
    }

    public List<Clube> saveClubes(List<Clube> clubes){
        return (List<Clube>) clubeRepository.saveAll(clubes);
    }

    public List<Clube> findAll() {
        return (List<Clube>)clubeRepository.findAll();
    }

    public Clube findById(Long id) {
        return clubeRepository.findById(id).orElseThrow(() -> new ClubeNotFoundException("Não foi encontrada nenhuma formação com esse ID"));
    }

    public Clube update(Long id, ClubeRequestDTO clubeRequestDTO){
        var clube = findById(id);
        modelMapper.map(clubeRequestDTO, clube);
        return clubeRepository.save(clube);
    }

    public ClubeResponseDTO conversorEntidadeParaDTO(Clube clubes){
        return modelMapper.map(clubes, ClubeResponseDTO.class);
    }

    public List<ClubeResponseDTO> conversorEntidadeParaDTO(List<Clube> clubes){
        return clubes.stream()
                .map(clube -> modelMapper.map(clube, ClubeResponseDTO.class))
                .collect(Collectors.toList());
    }


}
