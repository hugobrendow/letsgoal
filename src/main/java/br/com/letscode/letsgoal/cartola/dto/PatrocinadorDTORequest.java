package br.com.letscode.letsgoal.cartola.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class PatrocinadorDTORequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 10)
    private String descricao;
    @NotBlank
    private String urlLink;
    @NotBlank
    private String imagemMarca;
    @NotBlank
    @Size(min = 3)
    private String nome;
}