package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.dto.MercadoDTOResponse;
import br.com.letscode.letsgoal.model.Mercado;
import br.com.letscode.letsgoal.repositories.MercadoRepository;
import br.com.letscode.letsgoal.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MercadoService {

    private final MercadoRepository mercadoRepository;

    public MercadoService(MercadoRepository mercadoRepository) {
        this.mercadoRepository = mercadoRepository;
    }

    public List<MercadoDTOResponse> findAll(){
        List<Mercado> all = mercadoRepository.findAll();
        return all.stream().map(mercado -> {
            MercadoDTOResponse response = new MercadoDTOResponse();
            BeanUtils.copyProperties(mercado, response);
            return response;
        }).collect(Collectors.toList());
    }

    public MercadoDTOResponse findById(Long id){
        Mercado byId = mercadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        MercadoDTOResponse mercadoDTOResponse = new MercadoDTOResponse();
        BeanUtils.copyProperties(byId, mercadoDTOResponse);
        return mercadoDTOResponse;
    }

}
