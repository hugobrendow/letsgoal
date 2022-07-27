package br.com.letscode.letsgoal.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PatrocinadorDTO {
    @NotBlank
    private String descricao;
    @NotBlank
    private String urlLink;
    @NotBlank
    private String imagemMarca;
    @NotBlank
    private String nome;
}
