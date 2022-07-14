package br.com.letscode.letsgoal.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Clube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nomeClube;
    String abreviacao;
    List<Escudo> escudoList;
    String nomeFantasia;

}
