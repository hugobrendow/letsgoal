package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.UserAuthority;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserAuthorityRepository extends CrudRepository<UserAuthority, Integer> {

    Optional<UserAuthority> findByRole(String role);
}
