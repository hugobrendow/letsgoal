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
    private String nome;
    private String abreviacao;
    @OneToMany
    private List<Escudo> escudos;
    private String nomeFantasia;
}
