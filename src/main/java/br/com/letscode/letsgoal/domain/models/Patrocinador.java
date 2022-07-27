package br.com.letscode.letsgoal.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "table_sponsor")
@AllArgsConstructor
@NoArgsConstructor
public class Patrocinador {

    @Id
    private Long id;
    @Column(unique = true)
    private String nome;
    private String descricao;
    private String urlLink;
    private String image;

}
