package br.com.letscode.letsgoal.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EscudoDTO {
    @NotBlank
    private String tamanho60x60;
    @NotBlank
    private String tamanho45x45;
    @NotBlank
    private String tamanho30x30;
}
