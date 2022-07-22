package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.request.JogadorRequestDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.service.JogadorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jogadores")
@AllArgsConstructor
public class JogadorController {
    private JogadorService jogadorService;

    @ApiOperation(value = "Salva um Jogador")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PostMapping
    public ResponseEntity<Jogador> saveJogador(@RequestBody @Valid JogadorRequestDTO jogadorRequestDTO){
        Jogador jogador = getJogador(jogadorRequestDTO);
        Jogador jogadorSalvo = jogadorService.saveJogador(jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorSalvo);
    }


    @ApiOperation(value = "Lista todos os Jogadores")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping
    public ResponseEntity<List<Jogador>> findAll(){
        return  ResponseEntity.ok().body(jogadorService.findAll());
    }
    @ApiOperation(value = "Lista o Jogador com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping("/{id}")
    public ResponseEntity<Jogador> findById(@PathVariable ("id")Long id){
        return  ResponseEntity.ok().body(jogadorService.findByID(id));
    }

    @ApiOperation(value = "Atualiza o Jogador com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PutMapping("/{id}")
    public ResponseEntity<Jogador> updateJogador(@PathVariable ("id") Long id, @RequestBody @Valid JogadorRequestDTO jogadorRequestDTO){
        Jogador jogador = getJogador(jogadorRequestDTO);
        Jogador jogadorSalvo = jogadorService.updateJogador(id,jogador);

        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorSalvo);
    }
    private Jogador getJogador(JogadorRequestDTO jogadorRequestDTO) {
        Jogador jogador = new Jogador();
        Clube clube = new Clube();
        BeanUtils.copyProperties(jogadorRequestDTO,jogador);
        BeanUtils.copyProperties(jogadorRequestDTO.getClube(),clube);
        jogador.setClube(clube);
        return jogador;
    }


}
