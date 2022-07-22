package br.com.letscode.letsgoal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatrocinadorDTO {
    @NotBlank
    private String descricao;
    private String urlLink;
    private String imagemMarca;
    @NotBlank
    private String nome;
}
