package br.com.letscode.letsgoal.domain.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "table_player")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Boolean status;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Double mediaDePontos;
    @Column(nullable = false)
    private Double totalDePontos;
    @Column(nullable = false)
    private String apelido;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String foto;

}
