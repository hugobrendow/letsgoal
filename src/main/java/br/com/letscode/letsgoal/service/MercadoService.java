package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.MercadoNotFoundException;
import br.com.letscode.letsgoal.model.Mercado;
import br.com.letscode.letsgoal.repository.MercadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MercadoService {
    final MercadoRepository mercadoRepository;

    public Mercado viewStatus(Long id){
        return findById(id);
    }

    public Mercado changeStatus(Mercado mercado, Long id) {
        Mercado mercadoOriginal = findById(id);
        mercadoOriginal.setStatus(mercado.getStatus());
        return mercadoRepository.save(mercadoOriginal);
    }

    private Mercado findById(Long id) {
        return mercadoRepository.findById(id).orElseThrow(MercadoNotFoundException::new);
    }
}
