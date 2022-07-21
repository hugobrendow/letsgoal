package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Partida;
import br.com.letscode.letsgoal.service.PartidaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/partidas")
public class PartidaController {
    public PartidaService partidaService;
    @ApiOperation(value = "getGreeting")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista")})
    @GetMapping
    public List<Partida> findAll() {
       return partidaService.findAll();

    }
    @PostMapping
    public Partida savePartida(@RequestBody Partida partida) {
        return
                partidaService.savePartida(partida);
    }
    @PutMapping("/{id}")
    public Partida updateResultadoPartida(@PathVariable Long id,
                                           @RequestBody Partida partida) {
        return partida;
    }

}
