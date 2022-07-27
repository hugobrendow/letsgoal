package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Formacao;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LetsClubeDTO {
    @NotBlank
    private String nomeDoClube;
    @NotNull
    private Formacao formacao;
}
