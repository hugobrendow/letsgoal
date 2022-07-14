package br.com.letscode.letsgoal.service;


import br.com.letscode.letsgoal.model.Mercado;
import br.com.letscode.letsgoal.repository.MercadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MercadoService {

    final MercadoRepository mercadoRepository;


}
