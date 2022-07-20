package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.dto.JogadorDTOResponse;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.repositories.JogadorRepository;
import br.com.letscode.letsgoal.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public List<JogadorDTOResponse> findAll(){
        List<Jogador> all = jogadorRepository.findAll();
        return all.stream().map(jogador -> {
            JogadorDTOResponse response = new JogadorDTOResponse();
            BeanUtils.copyProperties(jogador, response);
            return response;
        }).collect(Collectors.toList());
    }

    public JogadorDTOResponse findById(Long id){
        Jogador byId = jogadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        JogadorDTOResponse jogadorDTOResponse = new JogadorDTOResponse();
        BeanUtils.copyProperties(byId, jogadorDTOResponse);
        return jogadorDTOResponse;
    }

}
