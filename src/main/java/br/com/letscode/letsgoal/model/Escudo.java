package br.com.letscode.letsgoal.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Escudo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String icon;
}
