package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Escudo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClubeDTO {
    private Long id;
    private String nomeDoClube;
    private String abreviacao;
    private List<Escudo> escudos;
    private String nomeFantasia;

    public ClubeDTO(Clube clube){
        id = clube.getId();
        nomeDoClube = clube.getNomeDoClube();
        abreviacao = clube.getAbreviacao();
        escudos = clube.getEscudos();
        nomeFantasia = clube.getNomeFantasia();
    }
}
