package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patrocinador {
    private Long id;
    private String descricao;
    private String urlLink;
    private String imagemMarca;
    private String nome;
}
