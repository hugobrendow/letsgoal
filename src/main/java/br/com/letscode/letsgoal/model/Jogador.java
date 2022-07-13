package br.com.letscode.letsgoal.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer status;
    private Integer preco;
    private Double mediaDePontos;
    private Integer totalDeJogos;
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    private String apelido;
    private String foto;
}
