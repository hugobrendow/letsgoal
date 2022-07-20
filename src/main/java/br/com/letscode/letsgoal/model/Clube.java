package br.com.letscode.letsgoal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clube")
public class Clube implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String abrevicao;
    @OneToOne
    @JoinColumn(name = "escudo_id", referencedColumnName = "id")
    private Escudo escudos;
    private String nomeFantasia;
    @JsonIgnore
    @OneToMany(mappedBy = "clube")
    private Set<Jogador> jogadores = new HashSet<>();

}
