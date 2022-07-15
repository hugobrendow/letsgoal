package br.com.letscode.letsgoal.repositories;

import br.com.letscode.letsgoal.model.LetsClube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LetsClubeRepository extends JpaRepository<LetsClube, Long> {
}
