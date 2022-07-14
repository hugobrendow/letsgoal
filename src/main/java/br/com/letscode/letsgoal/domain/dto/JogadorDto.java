package br.com.letscode.letsgoal.domain.dto;

import lombok.Data;

@Data
public class JogadorDto {
    private Boolean status;
    private Double price;
    private Double mediaDePontos;
    private Double totalDePontos;
    private String apelido;
    private String nome;
    private String foto;
}
