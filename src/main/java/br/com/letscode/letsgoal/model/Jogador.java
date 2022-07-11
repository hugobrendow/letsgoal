package br.com.letscode.letsgoal.model;

import lombok.Data;

@Data
public class Jogador {
    private Long id;
    private Integer status;
    private Integer preco;
    private Double mediaDePontos;
    private Integer totalDeJogos;
    private String nome;
    private String apelido;
    private String foto;
}
