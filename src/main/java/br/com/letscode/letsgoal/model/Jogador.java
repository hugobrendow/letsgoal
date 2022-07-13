package br.com.letscode.letsgoal.model;

import lombok.Data;

@Data
public class Jogador {
    private Long id;
    private String status;
    private Double preco;
    private Double mediaDePontos;
    private Double totalJogos;
    private String apelido;
    private String nome;
    private String foto;
}
