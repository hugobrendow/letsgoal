package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Formacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PosicaoDTO {
    @NotBlank
    private String nome;
    @NotNull
    List<Formacao> formacoes;

}
