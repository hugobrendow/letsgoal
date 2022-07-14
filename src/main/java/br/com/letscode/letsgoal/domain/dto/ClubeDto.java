package br.com.letscode.letsgoal.domain.dto;

import br.com.letscode.letsgoal.domain.models.Escudo;
import lombok.Data;

import java.util.List;

@Data
public class ClubeDto {
    private String nome;
    private String abreviacao;
    private List<Escudo> escudos;
    private String nomeFantasia;
}
