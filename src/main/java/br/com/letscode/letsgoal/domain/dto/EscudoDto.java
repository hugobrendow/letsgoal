package br.com.letscode.letsgoal.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EscudoDto {

    @NotEmpty
    private String sessentaPorSessenta;
    @NotEmpty
    private String quarentaCincoPorQuarentaCinco;
    @NotEmpty
    private String trintaPorTrinta;
}
