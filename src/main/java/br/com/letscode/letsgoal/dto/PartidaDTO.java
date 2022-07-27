package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Clube;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class PartidaDTO {
    @NotNull
    private Clube clubeCasa;
    @NotNull
    private Clube clubeVisitante;
    @NotBlank
    private LocalDateTime dataPartida;
    @NotBlank
    private String local;
    @NotBlank
    private int rodada;
    @NotBlank
    private int placarMandante;
    @NotBlank
    private int placarVisitante;
}
