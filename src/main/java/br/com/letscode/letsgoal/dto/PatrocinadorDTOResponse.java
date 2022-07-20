package br.com.letscode.letsgoal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatrocinadorDTOResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String descricao;
    private String urlLink;
    private String imagemMarca;
    private String nome;
}
