package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.PartidaDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Partida;
import br.com.letscode.letsgoal.service.PartidaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/partidas")
public class PartidaController {
    public PartidaService partidaService;
    @ApiOperation(value = "Salvar Partida")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Partida.class, responseContainer = "Lista")})
    @GetMapping
    public ResponseEntity<List<Partida>> findAll() {
        return ResponseEntity.ok().body(partidaService.findAll());

    }
    @PostMapping
    public ResponseEntity<Partida> save(@RequestBody PartidaDTO partidaDTO) {
        Partida partida = new Partida();
        BeanUtils.copyProperties(partidaDTO, partida);
        Partida partidaSalva = partidaService.save(partida);
        return ResponseEntity.status(HttpStatus.CREATED).body(partidaSalva);
    }
    @PutMapping("/{id}")
    public Partida update(@PathVariable Long id,
                                           @RequestBody PartidaDTO partidaDTO) {
        Partida partida = new Partida();
        BeanUtils.copyProperties(partidaDTO, partida);

        return partidaService.save(partida);
    }
    public ResponseEntity<Partida> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(partidaService.findById(id));
    }

}
