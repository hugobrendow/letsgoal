package br.com.letscode.letsgoal.DTO.ClubeDTO;

import br.com.letscode.letsgoal.DTO.EscudoDTO.EscudoRequestDTO;
import br.com.letscode.letsgoal.model.Escudo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubeRequestDTO {

    private String nomeDoClube;
    private String abreviacao;
    private EscudoRequestDTO escudos;
}
