package br.com.letscode.letsgoal.domain.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "table_letsclube")
public class LetsClube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToOne
    private Formacao formacao;
}
