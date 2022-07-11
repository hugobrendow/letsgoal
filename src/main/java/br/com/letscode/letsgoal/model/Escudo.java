package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Escudo {
    private Long id;
    private String formato60x60;
    private String formato45x45;
    private String formato30x30;
}
