package br.com.letscode.letsgoal.domain.dto;

import br.com.letscode.letsgoal.domain.models.Posicao;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class FormacaoDto {

    @NotEmpty
    private String nome;
    @NotEmpty
    private List<Posicao> posicaos;

}
