package br.com.letscode.letsgoal.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PatrocinadorDto {
    @NotEmpty
    private String descricao;
    @NotEmpty
    private String urlLink;
    @NotEmpty
    private String image;
    @NotEmpty
    private String nome;
}
