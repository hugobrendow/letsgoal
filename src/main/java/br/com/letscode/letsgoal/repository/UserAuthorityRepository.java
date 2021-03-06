package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Integer> {

}