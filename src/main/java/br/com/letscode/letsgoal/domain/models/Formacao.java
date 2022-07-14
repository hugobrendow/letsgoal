package br.com.letscode.letsgoal.domain.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "table_formation")
public class Formacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany
    private List<Posicao> posicaos;

}
