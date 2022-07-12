package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Escudo {

    private Long id;
    private String img60x60;
    private String img45x45;
    private String img30x30;
}
