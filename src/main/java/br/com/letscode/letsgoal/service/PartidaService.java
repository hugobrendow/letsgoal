package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.dto.PartidaDTOResponse;
import br.com.letscode.letsgoal.model.Partida;
import br.com.letscode.letsgoal.repositories.PartidaRepository;
import br.com.letscode.letsgoal.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartidaService {

    private final PartidaRepository partidaRepository;

    public PartidaService(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    public List<PartidaDTOResponse> findAll(){
        List<Partida> all = partidaRepository.findAll();
        return all.stream().map(partida -> {
            PartidaDTOResponse response = new PartidaDTOResponse();
            BeanUtils.copyProperties(partida, response);
            return response;
        }).collect(Collectors.toList());
    }

    public PartidaDTOResponse findById(Long id){
        Partida byId = partidaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        PartidaDTOResponse partidaDTOResponse = new PartidaDTOResponse();
        BeanUtils.copyProperties(byId, partidaDTOResponse);
        return partidaDTOResponse;
    }

}
