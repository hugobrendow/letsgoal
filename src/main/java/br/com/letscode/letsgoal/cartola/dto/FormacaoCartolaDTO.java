package br.com.letscode.letsgoal.cartola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
public class FormacaoCartolaDTO {
    private Long id;
    private String nome;
    List<PosicaoCartolaDTO> posicoesCartolaDTO;
}

