package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Escudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscudoRepository extends JpaRepository<Escudo, Long> {
}
