package br.com.letscode.letsgoal.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private double preco;
    private double mediaPontos;
    private int totalDeJogos;
    private String apelido;
    @Column(nullable = false, unique = true)
    private String nome;
    private String foto;
}
