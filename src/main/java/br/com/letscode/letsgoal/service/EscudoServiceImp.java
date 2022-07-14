package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.EscudoNotFoundException;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.repository.EscudoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EscudoServiceImp implements EscudoService{
    private final EscudoRepository escudoRepository;


    public Escudo saveEscudo(Escudo escudo) {
        return escudoRepository.save(escudo);
    }

    public List<Escudo> findAll() {
        return (List<Escudo>) escudoRepository.findAll();
    }

    public Escudo findByID(Long id) {
        return escudoRepository
                .findById(id)
                .orElseThrow(() -> new EscudoNotFoundException());
    }

    public Escudo updateEscudo(Long id, Escudo escudo) {
        return escudoRepository
                .findById(id)
                .map((record) ->{
                    record.setFormato30x30(escudo.getFormato30x30());
                    record.setFormato45x45(escudo.getFormato45x45());
                    record.setFormato60x60(escudo.getFormato60x60());
                    Escudo updatedEscudo = escudoRepository.save(record);
                    return updatedEscudo;
                }).orElseThrow(() -> new EscudoNotFoundException());
    }
}
