package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.LetsClubeNotFoundException;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.repository.LetsClubeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LetsClubeService {

    final LetsClubeRepository letsClubeRepository;

    public List<LetsClube> findAll(){
        return (List<LetsClube>) letsClubeRepository.findAll();
    }

    public LetsClube findById(Long id){
        LetsClube letsClube = letsClubeRepository
                .findById(id)
                .orElseThrow(() -> new LetsClubeNotFoundException());
        return letsClube;
    }

    public LetsClube saveLetsClube(LetsClube letsClube){
        return letsClubeRepository.save(letsClube);
    }
}
