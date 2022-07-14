package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Escudo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EscudoDTO {
    private Long id;
    private String formato60x60;
    private String formato45x45;
    private String formato30x30;

    public EscudoDTO(Escudo escudo){
        id = escudo.getId();
        formato30x30 = escudo.getFormato30x30();
        formato45x45 = escudo.getFormato45x45();
        formato60x60 = escudo.getFormato60x60();
    }
}
