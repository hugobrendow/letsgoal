package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.PatrocinadorNotFoundException;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.repository.PatrocinadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatrocinadorServiceImp implements PatrocinadorService{

    private final PatrocinadorRepository patrocinadorRepository;

    public Patrocinador savePatrocinador(Patrocinador patrocinador) {
        return patrocinadorRepository.save(patrocinador);
    }

    public List<Patrocinador> findAll() {

        return (List<Patrocinador>) patrocinadorRepository.findAll();
    }

    public Patrocinador findById(Long id) {
        Patrocinador patrocinador = patrocinadorRepository
                .findById(id)
                .orElseThrow(() -> new PatrocinadorNotFoundException());
        return patrocinador;
    }

    public Patrocinador updatePatrocinador(Long id, Patrocinador patrocinador) {
        return patrocinadorRepository
                .findById(id)
                .map(record ->{
                    record.setDescricao(patrocinador.getDescricao());
                    record.setImagemMarca(patrocinador.getImagemMarca());
                    record.setUrlLink(patrocinador.getUrlLink());
                    record.setNome(patrocinador.getNome());
                    Patrocinador updatedPatrocinador = patrocinadorRepository.save(record);
                    return updatedPatrocinador;
                }).orElseThrow(() ->new PatrocinadorNotFoundException());
    }

}
