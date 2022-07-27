package br.com.letscode.letsgoal.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "table_club")
@AllArgsConstructor
@NoArgsConstructor
public class Clube {

    @Id
    private Long id;
    private String nome;
    private String abreviacao;
    private String nomeFantasia;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "escudo_id", referencedColumnName = "id")
    private Escudo escudos;
}
