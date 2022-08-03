package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.model.User;
import br.com.letscode.letsgoal.model.UserAuthority;
import br.com.letscode.letsgoal.repository.UserAuthorityRepository;
import br.com.letscode.letsgoal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));

        return getUserDetails(user);
    }

    private org.springframework.security.core.userdetails.User getUserDetails(User user) {
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
        UserAuthority authority = authorityRepository.findByRole(role)
                .orElseThrow(() -> new RuntimeException("Authority not found!"));

        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .authority(authority)
                .build();
        user = userRepository.save(user);
        return getUserDetails(user);
    }
}

