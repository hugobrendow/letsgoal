package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.entity.Mercado;
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

}
