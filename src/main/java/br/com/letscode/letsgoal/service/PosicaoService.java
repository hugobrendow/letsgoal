package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.dto.PartidaDTOResponse;
import br.com.letscode.letsgoal.dto.PosicaoDTOResponse;
import br.com.letscode.letsgoal.model.Partida;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.repositories.PosicaoRepository;
import br.com.letscode.letsgoal.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PosicaoService {

    private final PosicaoRepository posicaoRepository;

    public PosicaoService(PosicaoRepository posicaoRepository) {
        this.posicaoRepository = posicaoRepository;
    }

    public List<PosicaoDTOResponse> findAll(){
        List<Posicao> all = posicaoRepository.findAll();
        return all.stream().map(posicao -> {
            PosicaoDTOResponse response = new PosicaoDTOResponse();
            BeanUtils.copyProperties(posicao, response);
            return response;
        }).collect(Collectors.toList());
    }

    public PosicaoDTOResponse findById(Long id){
        Posicao byId = posicaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        PosicaoDTOResponse posicaoDTOResponse = new PosicaoDTOResponse();
        BeanUtils.copyProperties(byId, posicaoDTOResponse);
        return posicaoDTOResponse;
    }

}
