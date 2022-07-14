package br.com.letscode.letsgoal.domain.dto;

import br.com.letscode.letsgoal.domain.models.Escudo;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class ClubeDto {

    @NotEmpty
    private String nome;
    @NotEmpty
    private String abreviacao;
    @NotEmpty
    private List<Escudo> escudos;
    @NotEmpty
    private String nomeFantasia;
}
