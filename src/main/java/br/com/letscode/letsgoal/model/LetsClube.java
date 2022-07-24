package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LetsClube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDoClube;
    @ManyToOne
    private Formacao formacao;
    @ManyToMany
    @JoinTable(name = "letsclube_patrocinador",
        joinColumns = @JoinColumn(name = "letsclube_id"),
        inverseJoinColumns = @JoinColumn(name = "patrocinador_id"))
    private List<Patrocinador> patrocinador;
}
