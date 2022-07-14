package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LetsClube {
    private Long id;
    private String nomeLetsClube;
    private Formacao formacao;
    private List<Patrocinador> patrocinadores;
    private List<Jogador> jogadores;
}
