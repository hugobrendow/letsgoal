package br.com.letscode.letsgoal.domain.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "table_position")
public class Posicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private long jogadorId;
}
