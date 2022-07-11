package br.com.letscode.letsgoal.model;

import lombok.Data;

@Data
public class Patrocinador {
    private Long id;
    private String descricao;
    private String urlLink;
    private String imagemMarca;
    private String nome;
}
