package br.com.letscode.letsgoal.cartola.dto;

import br.com.letscode.letsgoal.model.Escudo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClubeCartolaDTO {

    private Long id;
    private String nome;
    private String abreviacao;
    private String nomeFantasia;
    private EscudoCartolaDTO escudoCartolaDTO;
}
