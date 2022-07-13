package br.com.letscode.letsgoal.domain.models;

import lombok.Data;

@Data
public class Jogador {

    private Long id;
    private Boolean status;
    private Double price;
    private Double mediaDePontos;
    private Double totalDePontos;
    private String apelido;
    private String nome;
    private String foto;

}
