package br.com.letscode.letsgoal.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EscudoDto {

    @NotBlank
    private String tamanho60x60;
    @NotBlank
    private String tamanho45x45;
    @NotBlank
    private String tamanho30x30;
}
