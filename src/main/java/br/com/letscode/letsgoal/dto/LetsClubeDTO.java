package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Jogador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LetsClubeDTO {

    @NotBlank
    private String nome;

    @NotNull
    private Formacao formacao;

    List<JogadorDTO> jogadores;
}
