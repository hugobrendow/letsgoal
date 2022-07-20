package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jogadores {

    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String apelido;
    private String foto;
    private int totalDeJogos;
    private double mediaDePontos;
    private BigDecimal preco;
    private String status;
}
