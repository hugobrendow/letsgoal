package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.PatrocinadorNotFoundException;
import br.com.letscode.letsgoal.model.Mercado;
import br.com.letscode.letsgoal.repository.MercadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MercadoService {
    final MercadoRepository mercadoRepository;

    public Mercado saveClube(Mercado mercado) {
        return mercadoRepository.save(mercado);
    }

    public Mercado findById(Long id) {
        return mercadoRepository
                .findById(id)
                .orElseThrow(PatrocinadorNotFoundException::new);
    }
}
