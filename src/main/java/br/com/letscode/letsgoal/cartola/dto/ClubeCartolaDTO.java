package br.com.letscode.letsgoal.cartola.dto;

import br.com.letscode.letsgoal.model.Escudo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class ClubeCartolaDTO {
        private Long id;
        private String nome;
        private String abreviacao;
        private Escudo escudo;
        private String nomeFantasia;
    }
