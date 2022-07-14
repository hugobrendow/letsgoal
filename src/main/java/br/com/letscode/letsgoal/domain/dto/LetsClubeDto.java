package br.com.letscode.letsgoal.domain.dto;

import br.com.letscode.letsgoal.domain.models.Formacao;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LetsClubeDto {

    @NotEmpty
    private String nome;
    @NotEmpty
    private Formacao formacao;
}
