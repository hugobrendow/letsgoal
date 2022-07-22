package br.com.letscode.letsgoal.dto.request;

import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Patrocinador;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class LetsClubeRequestDTO {
    @NotBlank
    private String nomeDoClub;
    @NotNull
    private Formacao formacao;
    @NotNull
    private List<Patrocinador> patrocinadores;
}
