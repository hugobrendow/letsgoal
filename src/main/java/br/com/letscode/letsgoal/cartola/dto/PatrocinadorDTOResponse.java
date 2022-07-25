package br.com.letscode.letsgoal.cartola.dto;

import lombok.*;

import java.io.Serializable;

@Data
public class PatrocinadorDTOResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String descricao;
    private String urlLink;
    private String imagemMarca;
    private String nome;
}