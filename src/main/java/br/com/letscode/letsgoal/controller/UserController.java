package br.com.letscode.letsgoal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;

    //@Autowired private UserService service; // nele tem injecao de 2 outras classes

    @GetMapping("/{username}") //@RolesAllowed(ApplicationSecurityConfig.Roles.ADMIN)
    public ResponseEntity<UserDetails> get(@PathVariable("username") String username ) {
        if ( !inMemoryUserDetailsManager.userExists(username) )
            return ResponseEntity.noContent().build();

        UserDetails userDetails = inMemoryUserDetailsManager.loadUserByUsername(username);
        return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
    }

    @PostMapping ("/{username}/{role}/{password}")
    public ResponseEntity<UserDetails> save(@PathVariable("username") String username,
               @PathVariable("role") String role, @PathVariable("password") String password) {

        if (inMemoryUserDetailsManager.userExists(username)) {
            return new ResponseEntity<UserDetails>((UserDetails) null, HttpStatus.CONFLICT);
        }

        UserDetails theUser = User.withUsername(username)
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password(password).roles(role)
                .build();

        inMemoryUserDetailsManager.createUser(theUser);

        return new ResponseEntity<UserDetails>(theUser, HttpStatus.CREATED);
    }

    /*
    @PutMapping ("/{username}/{role}/{password}")
    public ResponseEntity<UserDetails> saveDB(@PathVariable("username") String username,
                @PathVariable("role") String role, @PathVariable("password") String password) {
        User user = service.loadUserByUsername(username);
        if (user == null) {
            return new ResponseEntity<UserDetails>((UserDetails) null, HttpStatus.CONFLICT);
        }

        UserDetails theUser = service.save( username, role, password);
        return new ResponseEntity<UserDetails>(theUser, HttpStatus.CREATED);
    }
    */

}
