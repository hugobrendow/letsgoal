package br.com.letscode.letsgoal.domain.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "table_sponsor")
public class Patrocinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String urlLink;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false)
    private String nome;
}
