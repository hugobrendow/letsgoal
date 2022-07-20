package br.com.letscode.letsgoal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
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
