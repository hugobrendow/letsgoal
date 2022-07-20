package br.com.letscode.letsgoal.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PartidaDTORequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String clubeCasa;
    private String clubeVisitante;
    private String dataPartida;
    private String local;
    private String rodada;
    private String placarMandante;
    private String placarVisitante;
}
