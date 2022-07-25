package br.com.letscode.letsgoal.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ClubeDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String abreviacao;
    @NotBlank
    private String nomeFantasia;
    @NotNull
    private EscudoDTO escudo;
}
