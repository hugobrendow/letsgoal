package br.com.letscode.letsgoal.repositories;

import br.com.letscode.letsgoal.model.Patrocinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatrocinadorRepository extends JpaRepository<Patrocinador, Long> {
}
