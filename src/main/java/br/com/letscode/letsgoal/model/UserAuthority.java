package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@SuppressWarnings("ALL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="authorities")
public class UserAuthority {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Long id;

    private String role;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

}



