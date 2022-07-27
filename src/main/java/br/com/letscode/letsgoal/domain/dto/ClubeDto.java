package br.com.letscode.letsgoal.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class ClubeDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String abreviacao;
    @NotBlank
    private String nomeFantasia;
    @NotEmpty
    private EscudoDto escudos;
}
