package br.com.letscode.letsgoal.dto.request;

import br.com.letscode.letsgoal.model.Jogador;
import lombok.Data;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PosicaoRequestDTO {
    @NotBlank
    private String nome;
    @NotNull
    private List<Jogador> jogadores;
}
