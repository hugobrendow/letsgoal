package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Escudo {
    private Long id;
    private String escudo60x60;//Confirmar tipo
    private String escudo45x45;//Confirmar tipo
    private String escudo30x30;//Confirmar tipo

}
