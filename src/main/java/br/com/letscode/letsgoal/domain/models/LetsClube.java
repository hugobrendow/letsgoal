package br.com.letscode.letsgoal.domain.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "table_letsclube")
public class LetsClube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @ManyToOne
    @JoinColumn(name = "formacao_id", referencedColumnName = "id", nullable = false)
    private Formacao formacao;
    @ManyToMany
    @JoinTable( name = "table_letsclube_patrocinadores",
            joinColumns = @JoinColumn(name = "letsclube_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "patrocinador_id", referencedColumnName = "id")
    )
    private List<Patrocinador> patrocinadores;
}
