package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.dto.PatrocinadorDTORequest;
import br.com.letscode.letsgoal.dto.PatrocinadorDTOResponse;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.repositories.PatrocinadorRepository;
import br.com.letscode.letsgoal.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatrocinadorService {

    private final PatrocinadorRepository patrocinadorRepository;

    public PatrocinadorService(PatrocinadorRepository patrocinadorRepository) {
        this.patrocinadorRepository = patrocinadorRepository;
    }

    public List<PatrocinadorDTOResponse> findAll(){
        List<Patrocinador> all = patrocinadorRepository.findAll();
        return all.stream()
                .map(patrocinador -> {
                    PatrocinadorDTOResponse response = new PatrocinadorDTOResponse();
                    BeanUtils.copyProperties(patrocinador, response);
                    return response;
                }).collect(Collectors.toList());
    }

    public PatrocinadorDTOResponse findByid(Long id){
        Patrocinador byId = patrocinadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        PatrocinadorDTOResponse response = new PatrocinadorDTOResponse();
        BeanUtils.copyProperties(byId, response);
        return response;
    }

    @Transactional
    public PatrocinadorDTOResponse save(PatrocinadorDTORequest request){
        Patrocinador patrocinador = new Patrocinador();
        BeanUtils.copyProperties(request,patrocinador);
        patrocinadorRepository.save(patrocinador);

        PatrocinadorDTOResponse response = new PatrocinadorDTOResponse();
        BeanUtils.copyProperties(patrocinador, response);
        return response;
    }

    @Transactional
    public PatrocinadorDTOResponse update(Long id, PatrocinadorDTORequest request){

        Patrocinador patrocinador = patrocinadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        BeanUtils.copyProperties(request, patrocinador);
        patrocinadorRepository.save(patrocinador);
        PatrocinadorDTOResponse response = new PatrocinadorDTOResponse();
        BeanUtils.copyProperties(patrocinador, response);
        return response;
    }

}
