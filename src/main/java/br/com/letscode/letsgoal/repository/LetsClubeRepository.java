package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.LetsClube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LetsClubeRepository extends JpaRepository<LetsClube, Long> {
}
