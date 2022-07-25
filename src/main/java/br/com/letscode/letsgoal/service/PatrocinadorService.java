package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.cartola.dto.PatrocinadorDTORequest;
import br.com.letscode.letsgoal.cartola.dto.PatrocinadorDTOResponse;
import br.com.letscode.letsgoal.exception.PatrocinadorNotFoundException;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.repository.PatrocinadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatrocinadorService {

    final PatrocinadorRepository patrocinadorRepository;

    public PatrocinadorService(PatrocinadorRepository patrocinadorRepository) {
        this.patrocinadorRepository = patrocinadorRepository;
    }


    public List<PatrocinadorDTOResponse> findAll(){
        List<Patrocinador> patrociandores = patrocinadorRepository.findAll();
        return patrociandores.stream()
                .map(patrocinador -> {
                    PatrocinadorDTOResponse response = new PatrocinadorDTOResponse();
                    BeanUtils.copyProperties(patrocinador, response);
                    return response;
                }).collect(Collectors.toList());
    }

    public PatrocinadorDTOResponse findByid(Long id){
        Patrocinador byId = patrocinadorRepository
                .findById(id)
                .orElseThrow(() -> new PatrocinadorNotFoundException());

        PatrocinadorDTOResponse response = new PatrocinadorDTOResponse();
        BeanUtils.copyProperties(byId, response);
        return response;
    }

    @Transactional
    public PatrocinadorDTOResponse savePatrocinador(PatrocinadorDTORequest request){
        Patrocinador patrocinador = new Patrocinador();
        BeanUtils.copyProperties(request,patrocinador);
        patrocinadorRepository.save(patrocinador);

        PatrocinadorDTOResponse response = new PatrocinadorDTOResponse();
        BeanUtils.copyProperties(patrocinador, response);
        return response;
    }

    @Transactional
    public PatrocinadorDTOResponse updatePatrocinador(Long id, PatrocinadorDTORequest request){

        Patrocinador patrocinador = patrocinadorRepository.findById(id)
                .orElseThrow(() -> new PatrocinadorNotFoundException());
        BeanUtils.copyProperties(request, patrocinador);
        patrocinadorRepository.save(patrocinador);
        PatrocinadorDTOResponse response = new PatrocinadorDTOResponse();
        BeanUtils.copyProperties(patrocinador, response);
        return response;
    }

}
