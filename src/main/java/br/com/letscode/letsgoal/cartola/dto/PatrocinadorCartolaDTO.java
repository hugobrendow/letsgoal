package br.com.letscode.letsgoal.cartola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatrocinadorCartolaDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String urlLink;
    private String image;
}
