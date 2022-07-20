package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Clube;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class PartidaDTOResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Clube clubeCasa;
    private Clube clubeVisitante;
    private LocalDate dataPartida;
    private String local;
    private String rodada;
    private Integer placarMandante;
    private Integer placarVisitante;

}
