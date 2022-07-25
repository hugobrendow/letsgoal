package br.com.letscode.letsgoal.cartola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PosicaoCartolaDTO {


    private String nome;
    @NotBlank
    private String abreviacao;

    public PosicaoCartolaDTO(String abreviacao){
        this.abreviacao = abreviacao;
        switch(abreviacao){
            case "ata":
                this.nome = "Atacante";
                break;
            case "gol":
                this.nome = "Goleiro";
                break;
            case "lat":
                this.nome = "Lateral";
                break;
            case "mei":
                this.nome = "Meia";
                break;
            case "tec":
                this.nome = "Técnico";
                break;
            case "zag":
                this.nome = "Zagueiro";
                break;
        }
    }
}

