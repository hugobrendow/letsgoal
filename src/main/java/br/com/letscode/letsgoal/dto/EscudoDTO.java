package br.com.letscode.letsgoal.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EscudoDTO implements Serializable {
    private String tamanho60x60;
    private String tamanho45x45;
    private String tamanho30x30;
}
