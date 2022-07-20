package br.com.letscode.letsgoal.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lets_clube")
public class LetsClube implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToOne
    @JoinColumn(name = "formacao_id", referencedColumnName = "id")
    private Formacao formacao;
    @OneToMany
    @JoinColumn(name = "letsclube_id", referencedColumnName = "id")
    private Set<Patrocinador> patrocinadores = new HashSet<>();
    @OneToMany
    @JoinColumn(name = "letsclube_id", referencedColumnName = "id")
    private Set<Jogador> jogadores = new HashSet<>();

}
