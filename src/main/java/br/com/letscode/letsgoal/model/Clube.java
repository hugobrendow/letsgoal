package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clube {
    private Long id;
    private String nomeClube;
    private String abreviacao;
    private List<Escudo> escudo;
    private String nomeFantasia;
    private List<Jogador> jogadores;
}
