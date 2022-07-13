package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Mercado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercadoRepository extends CrudRepository<Mercado, Long> {
}
