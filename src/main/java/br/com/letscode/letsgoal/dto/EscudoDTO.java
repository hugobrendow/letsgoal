package br.com.letscode.letsgoal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EscudoDTO {

    @NotBlank
    private String tamanho60x60;
    @NotBlank
    private String tamanho45x45;

    private String tamanho30x30;
}
