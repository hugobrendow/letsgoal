package br.com.letscode.letsgoal.security.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "tb_authorities")
public class UserAuthority implements GrantedAuthority, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private long id;
    private String role;

    @ManyToMany(mappedBy = "authorities")
    private Set<UserModel> userModels;

    @Override
    public String getAuthority() {
        return this.role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<UserModel> getUsers() {
        return userModels;
    }

    public void setUsers(Set<UserModel> userModels) {
        this.userModels = userModels;
    }
}
