package br.com.letscode.letsgoal.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EscudoRequestDTO {
    @NotBlank
    private String formato60x60;
    @NotBlank
    private String formato45x45;
    private String formato30x30;
}
