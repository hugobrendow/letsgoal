package br.com.letscode.letsgoal.domain.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "table_player")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean status;
    private Double price;
    private Double mediaDePontos;
    private Double totalDePontos;
    private String apelido;
    private String nome;
    private String foto;

}
