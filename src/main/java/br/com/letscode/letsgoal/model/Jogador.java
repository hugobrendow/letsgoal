package br.com.letscode.letsgoal.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jogador {
    private Long id;
    private String status;
    private double preco;
    private double mediaPontos;
    private int totalDeJogos;
    private String apelido;
    private String nome;
    private String foto;
}
