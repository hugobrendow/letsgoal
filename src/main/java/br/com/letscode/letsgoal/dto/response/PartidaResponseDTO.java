package br.com.letscode.letsgoal.dto.response;

import br.com.letscode.letsgoal.model.Partida;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartidaResponseDTO {
    private Long id;
    private String clubeCasa;
    private String clubeVisitante;
    private LocalDate dataPartida;
    private String local;
    private Long rodada;
    private Integer placarMandante;
    private Integer placarVisitante;

    public PartidaResponseDTO(Partida partida){
        id = partida.getId();
        clubeCasa = partida.getClubeCasa();
        dataPartida = partida.getDataPartida();
        local = partida.getLocal();
        rodada = partida.getRodada();
        placarMandante = partida.getPlacarMandante();
        placarVisitante = partida.getPlacarVisitante();

    }
}
