package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Clube {

    @Id
    private Long id;
    private String nome;
    private String abreviacao;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "escudo_id", referencedColumnName = "id") //a coluna que vai ser criada dentro do escudo a nivel de banco
    private Escudo escudo;
    private String nomeFantasia;
}
