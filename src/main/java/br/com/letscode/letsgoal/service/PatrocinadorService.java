package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.dto.PatrocinadorRequest;
import br.com.letscode.letsgoal.dto.PatrocinadorResponse;
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

    public List<PatrocinadorResponse> findAll(){
        List<Patrocinador> all = patrocinadorRepository.findAll();
        return all.stream()
                .map(patrocinador -> {
                    PatrocinadorResponse response = new PatrocinadorResponse();
                    BeanUtils.copyProperties(patrocinador, response);
                    return response;
                }).collect(Collectors.toList());
    }

    public PatrocinadorResponse findByid(Long id){
        Patrocinador byId = patrocinadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        PatrocinadorResponse response = new PatrocinadorResponse();
        BeanUtils.copyProperties(byId, response);
        return response;
    }

    @Transactional
    public PatrocinadorResponse save(PatrocinadorRequest request){
        Patrocinador patrocinador = new Patrocinador();
        BeanUtils.copyProperties(request,patrocinador);
        patrocinadorRepository.save(patrocinador);

        PatrocinadorResponse response = new PatrocinadorResponse();
        BeanUtils.copyProperties(patrocinador, response);
        return response;
    }

    @Transactional
    public PatrocinadorResponse update(Long id, PatrocinadorRequest request){

        Patrocinador patrocinador = patrocinadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        BeanUtils.copyProperties(request, patrocinador);
        patrocinadorRepository.save(patrocinador);
        PatrocinadorResponse response = new PatrocinadorResponse();
        BeanUtils.copyProperties(patrocinador, response);
        return response;
    }

}
