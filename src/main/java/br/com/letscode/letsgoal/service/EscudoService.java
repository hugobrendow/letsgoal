package br.com.letscode.letsgoal.service;


import br.com.letscode.letsgoal.exception.EscudoNotFoundException;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.repository.EscudoRepository;
import br.com.letscode.letsgoal.repository.LetsClubeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EscudoService {

    final EscudoRepository escudoRepository;

    public List<Escudo> findAll(){
        return (List<Escudo>) escudoRepository.findAll();
    }

    public Escudo findById(Long id){
        Escudo escudo = escudoRepository
                .findById(id)
                .orElseThrow(() -> new EscudoNotFoundException());
        return escudo;
    }

    public Escudo saveEscudo(Escudo escudo){
        return escudoRepository.save(escudo);
    }
}
