package br.com.letscode.letsgoal.dto.response;

import br.com.letscode.letsgoal.model.Mercado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MercadoResponseDTO {
    private Long id;
    private String status;

    public MercadoResponseDTO(Mercado mercado){
        id = mercado.getId();
        status = mercado.getStatus();
    }
}
