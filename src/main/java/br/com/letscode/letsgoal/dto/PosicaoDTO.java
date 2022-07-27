package br.com.letscode.letsgoal.dto;

import javax.validation.constraints.NotBlank;

public class PosicaoDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String abreviacao;
}
