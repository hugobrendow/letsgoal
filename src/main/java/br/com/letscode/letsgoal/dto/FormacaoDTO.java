package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Posicao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormacaoDTO {

    @NotBlank
    private String nome;

    private List<Posicao> posicoes;
}
