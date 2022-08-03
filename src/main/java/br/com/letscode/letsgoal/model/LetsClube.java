package br.com.letscode.letsgoal.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class LetsClube {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    @ManyToOne
    private Formacao formacao;

    @ManyToMany
    private List<Jogador> jogadores;
}
