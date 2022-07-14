package br.com.letscode.letsgoal.domain.dto;

import br.com.letscode.letsgoal.domain.models.Posicao;
import lombok.Data;

import java.util.List;

@Data
public class FormacaoDto {
    private String nome;
    private List<Posicao> posicaos;

}
