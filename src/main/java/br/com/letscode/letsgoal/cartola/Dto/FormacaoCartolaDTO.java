package br.com.letscode.letsgoal.cartola.Dto;

import br.com.letscode.letsgoal.model.Posicao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormacaoCartolaDTO {

    private Long id;
    private String nome;
    private Map<String, Long> posicoes;
}
