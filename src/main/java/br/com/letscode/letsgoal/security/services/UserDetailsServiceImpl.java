package br.com.letscode.letsgoal.security.services;

import br.com.letscode.letsgoal.security.models.UserModel;
import br.com.letscode.letsgoal.security.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username" + username));

        return new User(userModel.getUsername(), userModel.getPassword(), true, true,
                true, true, userModel.getAuthorities());
    }
}
