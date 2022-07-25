package br.com.letscode.letsgoal.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EscudoDTO {
    @NotBlank
    private String escudo60x60;//Confirmar tipo
    @NotBlank
    private String escudo45x45;//Confirmar tipo
    private String escudo30x30;//Confirmar tipo
}
