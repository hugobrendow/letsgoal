package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.model.UserAuthority;
import br.com.letscode.letsgoal.model.User;
import br.com.letscode.letsgoal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@Service
@Slf4j
@RequiredArgsConstructor
public class UserService { // implements org.springframework.security.core.userdetails.UserDetailsService

    private final UserRepository repository;
    //@Autowired private JdbcUserDetailsManager userDetailsManager; // ficaria no service
    //@Autowired private PasswordEncoder passwordEncoder; // para encryptar a senha recebida no request e passar

    //@Override
    public org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Getting UserBean info via JPA");

        User user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("UserBean name: " + username + " not found"));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.getEnabled(), user.getAccountNonExpired(), user.getCredentialsNonExpired(),
                user.getAccountNonLocked(), convertToSpringAuthorities(user.getAuthorities()));
    }

    private Collection<? extends GrantedAuthority> convertToSpringAuthorities(Set<UserAuthority> authorities) {
        if (CollectionUtils.isEmpty(authorities)) {
            return new HashSet<>();
        }
        return authorities.stream()
                .map(UserAuthority::getRole)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    public UserDetails save(String username, String role, String password) {
        throw new RuntimeException();
    }
}
