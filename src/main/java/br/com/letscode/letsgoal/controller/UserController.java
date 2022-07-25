package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.User;
import br.com.letscode.letsgoal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<UserDetails> get(@PathVariable("username") String username ) {
        UserDetails userDetails = userService.loadUserByUsername(username);

        return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
    }

    @PostMapping ("/{username}/{role}/{password}")
    public ResponseEntity<UserDetails> save(@PathVariable("username") String username,
               @PathVariable("role") String role, @PathVariable("password") String password) {
        UserDetails userDetails = userService.save(username, role, password);
        return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
    }
}
