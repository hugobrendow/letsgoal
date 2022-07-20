package br.com.letscode.letsgoal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
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
