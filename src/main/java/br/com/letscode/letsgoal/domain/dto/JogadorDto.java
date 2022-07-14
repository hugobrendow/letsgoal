package br.com.letscode.letsgoal.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class JogadorDto {

    @NotEmpty
    private Boolean status;
    @NotEmpty
    private Double price;
    @NotEmpty
    private Double mediaDePontos;
    @NotEmpty
    private Double totalDePontos;
    @NotEmpty
    private String apelido;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String foto;
}
