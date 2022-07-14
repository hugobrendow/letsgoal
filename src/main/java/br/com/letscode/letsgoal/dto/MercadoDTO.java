package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Mercado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MercadoDTO {
    private Long id;
    private String status;

    public MercadoDTO(Mercado mercado){
        id = mercado.getId();
        status = mercado.getStatus();
    }
}
