package br.com.letscode.letsgoal.cartola.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubeCartolaDTO {
    private Long id;
    private String nome;
    private String abreviacao;
    private String nomeFantasia;
    private EscudoCartolaDTO escudo;
}
