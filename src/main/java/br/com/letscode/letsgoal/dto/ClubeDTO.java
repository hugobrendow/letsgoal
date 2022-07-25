package br.com.letscode.letsgoal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubeDTO {

    @NotNull
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String abreviacao;
    @NotBlank
    private String nomeFantasia;
    @NotNull
    private EscudoDTO escudo;
}
