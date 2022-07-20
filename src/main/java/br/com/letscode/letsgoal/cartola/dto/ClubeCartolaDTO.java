package br.com.letscode.letsgoal.cartola.dto;

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
    private String escudos;
    private String nome_fantasia;
}
