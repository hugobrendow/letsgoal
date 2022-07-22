package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.JogadorDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.service.JogadorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    final JogadorService jogadorService;

    @ApiOperation(value = "Salvar Jogador")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Jogador.class, responseContainer = "Lista")})

    @PostMapping
    public ResponseEntity<Jogador> save(@RequestBody @Valid JogadorDTO jogadorDTO) {
        Jogador jogador = new Jogador();
        BeanUtils.copyProperties(jogadorDTO, jogador);
        jogadorService.save(jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogador);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(jogadorService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogador> update(@PathVariable("id") Long id, @RequestBody @Valid JogadorDTO jogadorDTO) {
        Jogador jogador = new Jogador();
        BeanUtils.copyProperties(jogadorDTO, jogador);
        Jogador jogadorSalvo = jogadorService.update(jogador, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> findAll() {
        return ResponseEntity.ok().body(jogadorService.findAll());
    }

}
