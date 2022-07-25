package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Escudo;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ClubeDTO {
    @NotBlank
    private String nomeClube;
    @NotBlank
    private String abreviacao;
    @NotBlank
    private String nomeFantasia;
    @NotNull
    private EscudoDTO escudo;
}
