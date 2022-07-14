package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.ClubeNotFoundException;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.repository.ClubeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClubeService {

    final ClubeRepository clubeRepository;

    public Clube saveClube(Clube clube){
        return clubeRepository.save(clube);
    }

    public List<Clube> findAll(){
        return (List<Clube>) clubeRepository.findAll();
    }

    public Clube findById(Long id){
        Clube clube = clubeRepository
                .findById(id)
                .orElseThrow(() -> new ClubeNotFoundException());

                return clube;
    }
}
