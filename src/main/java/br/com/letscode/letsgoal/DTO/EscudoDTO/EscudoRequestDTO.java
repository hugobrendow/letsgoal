package br.com.letscode.letsgoal.DTO.EscudoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EscudoRequestDTO {
    private String tamanho60x60;
    private String tamanho45x45;
    private String tamanho30x30;
}
