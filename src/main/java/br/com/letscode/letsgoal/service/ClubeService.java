package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.dto.ClubeDTOResponse;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.repositories.ClubeRepository;
import br.com.letscode.letsgoal.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubeService {

    private final ClubeRepository clubeRepository;

    public ClubeService(ClubeRepository clubeRepository) {
        this.clubeRepository = clubeRepository;
    }

    public List<ClubeDTOResponse> findAll(){
        List<Clube> all = clubeRepository.findAll();
        return all.stream().map(clube -> {
            ClubeDTOResponse response = new ClubeDTOResponse();
            BeanUtils.copyProperties(clube, response);
            return response;
        }).collect(Collectors.toList());
    }

    public ClubeDTOResponse findById(Long id){
        Clube byId = clubeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        ClubeDTOResponse clubeDTOResponse = new ClubeDTOResponse();
        BeanUtils.copyProperties(byId, clubeDTOResponse);
        return clubeDTOResponse;
    }

}
