package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Escudo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscudoRepository extends JpaRepository<Escudo, Long> {
}
