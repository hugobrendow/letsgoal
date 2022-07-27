package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Posicao;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class FormacaoDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private List<Posicao> posicoes;
}
