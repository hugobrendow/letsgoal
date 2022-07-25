package br.com.letscode.letsgoal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PosicaoDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String abreviacao;

}
