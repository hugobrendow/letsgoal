package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Clube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String abreviacao;
    private String nomeFantasia;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "escudo_id", referencedColumnName = "id")
    private Escudo escudo;
}
