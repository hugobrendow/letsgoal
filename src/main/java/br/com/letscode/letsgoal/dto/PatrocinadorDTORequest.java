package br.com.letscode.letsgoal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
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
