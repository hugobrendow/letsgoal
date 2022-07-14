package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Posicao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormacaoDTO {
    private Long id;
    private String nome;
    private List<Posicao> posicoes;

    public FormacaoDTO(Formacao formacao){
        id = formacao.getId();
        nome = formacao.getNome();
        posicoes = formacao.getPosicoes();
    }
}
