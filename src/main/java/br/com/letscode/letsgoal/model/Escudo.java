package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Escudo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    String bigPictureURL;
    String mediumPictureURL;
    String smallPictureURL;
}
