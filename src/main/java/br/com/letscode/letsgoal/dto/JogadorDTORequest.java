package br.com.letscode.letsgoal.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class JogadorDTORequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String status;
    @NotBlank
    private String preco;
    @NotBlank
    private String mediaDePontos;
    @NotBlank
    private String totalDeJogos;
    @NotBlank
    private String apelido;
    @NotBlank
    private String nome;
    @NotBlank
    private String urlFoto;
    @NotBlank
    private String clube;
    @NotBlank
    private String posicao;
}
