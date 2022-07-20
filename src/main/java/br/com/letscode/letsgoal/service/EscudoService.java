package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.dto.EscudoDTOResponse;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.repositories.EscudoRepository;
import br.com.letscode.letsgoal.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EscudoService {

    private final EscudoRepository escudoRepository;

    public EscudoService(EscudoRepository escudoRepository) {
        this.escudoRepository = escudoRepository;
    }

    public List<EscudoDTOResponse> findAll(){
        List<Escudo> all = escudoRepository.findAll();
        return all.stream().map(escudo -> {
            EscudoDTOResponse response = new EscudoDTOResponse();
            BeanUtils.copyProperties(escudo, response);
            return response;
        }).collect(Collectors.toList());
    }

    public EscudoDTOResponse findById(Long id){
        Escudo byId = escudoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        EscudoDTOResponse escudoDTOResponse = new EscudoDTOResponse();
        BeanUtils.copyProperties(byId, escudoDTOResponse);
        return escudoDTOResponse;
    }

}
