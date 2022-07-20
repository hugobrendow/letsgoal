package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.dto.LetsClubeDTOResponse;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.repositories.LetsClubeRepository;
import br.com.letscode.letsgoal.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LetsClubeService {

    private final LetsClubeRepository letsClubeRepository;

    public LetsClubeService(LetsClubeRepository letsClubeRepository) {
        this.letsClubeRepository = letsClubeRepository;
    }

    public List<LetsClubeDTOResponse> findAll(){
        List<LetsClube> all = letsClubeRepository.findAll();
        return all.stream().map(letsClube -> {
            LetsClubeDTOResponse response = new LetsClubeDTOResponse();
            BeanUtils.copyProperties(letsClube, response);
            return response;
        }).collect(Collectors.toList());
    }

    public LetsClubeDTOResponse findById(Long id){
        LetsClube byId = letsClubeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        LetsClubeDTOResponse letsClubeDTOResponse = new LetsClubeDTOResponse();
        BeanUtils.copyProperties(byId, letsClubeDTOResponse);
        return letsClubeDTOResponse;
    }

}
