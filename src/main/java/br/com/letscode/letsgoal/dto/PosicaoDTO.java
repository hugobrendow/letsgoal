package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Posicao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PosicaoDTO {
    private Long id;
    private String nome;
    private Integer jogadorID;

    public PosicaoDTO(Posicao posicao){
        id = posicao.getId();
        nome = posicao.getNome();
        jogadorID = posicao.getJogadorID();
    }
}
