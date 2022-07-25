package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.ClubeExistenteException;
import br.com.letscode.letsgoal.exception.ClubeNotFoundException;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.repository.ClubeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClubeService {

    final ClubeRepository clubeRepository; //Contém as funções relacionadas ao banco

    public Clube saveClube(Clube clube){
        Optional<Clube> optionalClube = clubeRepository.findByNomeOrAbreviacao(clube.getNomeClube(), clube.getAbreviacao());
        optionalClube.ifPresent(obj -> {throw new ClubeExistenteException();});

        //Se não o clube já for existente, retornar um erro específico e não salvar mais

        return clubeRepository.save(clube);
    }

    public Clube updateClube(Clube clube, Long id){
        clubeRepository.findById(id).orElseThrow(()-> new ClubeExistenteException());
        clube.setId(id);
        return clubeRepository.save(clube);
    }

    public List<Clube> findAll(){
        return (List<Clube>) clubeRepository.findAll();
    }

    public Clube findById(Long id){
        return clubeRepository
                .findById(id)
                .orElseThrow(ClubeNotFoundException::new);
    }

}
