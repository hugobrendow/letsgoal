package br.com.letscode.letsgoal.domain.dto;

import br.com.letscode.letsgoal.domain.models.Formacao;
import lombok.Data;

@Data
public class LetsClubeDto {
    private String nome;
    private Formacao formacao;
}
