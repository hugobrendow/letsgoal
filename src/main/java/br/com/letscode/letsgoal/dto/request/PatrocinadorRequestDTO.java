package br.com.letscode.letsgoal.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class PatrocinadorRequestDTO {
    @NotBlank
    private String descricao;
    @NotBlank
    private String urlLink;
    @NotBlank
    private String imagemMarca;
    @NotBlank
    private String nome;
}
