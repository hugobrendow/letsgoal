package br.com.letscode.letsgoal.security.repositories;

import br.com.letscode.letsgoal.security.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

    Optional<UserModel> findByUsername(String username);
}
