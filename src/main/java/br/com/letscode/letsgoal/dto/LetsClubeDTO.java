package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.LetsClube;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LetsClubeDTO {
    private Long id;
    private String nomeDoClub;
    private Formacao formacao;

    public LetsClubeDTO(LetsClube letsClube){
        id = letsClube.getId();
        nomeDoClub = letsClube.getNomeDoClub();
        formacao = letsClube.getFormacao();
    }

}
