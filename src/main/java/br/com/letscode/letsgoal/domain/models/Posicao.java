package br.com.letscode.letsgoal.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "table_position")
@AllArgsConstructor
@NoArgsConstructor
public class Posicao {

    @Id
    private Long id;
    private String nome;
    private String abreviacao;
}
