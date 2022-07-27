package br.com.letscode.letsgoal.cartola.dto;

import br.com.letscode.letsgoal.domain.models.Posicao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormacaoCartolaDTO {

    private long id;
    private String nome;
    private List<PosicaoCartolaDTO> posicaos;
}
