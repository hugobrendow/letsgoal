package br.com.letscode.letsgoal.dto.request;

import br.com.letscode.letsgoal.model.Posicao;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class FormacaoRequestDTO {
    @NotBlank
    private String nome;
    @NotNull
    private List<Posicao> posicoes;
}
