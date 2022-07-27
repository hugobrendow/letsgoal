package br.com.letscode.letsgoal.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "table_formation")
@AllArgsConstructor
@NoArgsConstructor
public class Formacao {

    @Id
    private Long id;
    private String nome;
    @ManyToMany
    @JoinTable( name = "table_formation_position",
            joinColumns = @JoinColumn(name = "formacao_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "posicao_id", referencedColumnName = "id")
    )
    private List<Posicao> posicaos;
}
