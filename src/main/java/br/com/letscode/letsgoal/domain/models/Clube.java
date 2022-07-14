package br.com.letscode.letsgoal.domain.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "table_club")
public class Clube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String abreviacao;
    @OneToMany
    @Column(nullable = false)
    private List<Escudo> escudos;
    @Column(nullable = false)
    private String nomeFantasia;
}
