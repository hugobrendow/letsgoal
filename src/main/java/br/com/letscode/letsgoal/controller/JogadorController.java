package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.JogadorDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.service.JogadorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public JogadorDTO saveJogador(@RequestBody Jogador jogador){
        return new JogadorDTO(jogadorService.saveJogador(jogador));
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
    public List<JogadorDTO> findAll(){
        List<JogadorDTO> jogadoresDTO = new ArrayList<>();
        jogadorService.findAll()
                .forEach(jogador -> {jogadoresDTO.add(new JogadorDTO(jogador));});
        return jogadoresDTO;
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
    public JogadorDTO findById(@PathVariable Long id){
        return new JogadorDTO(jogadorService.findByID(id));
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
    public JogadorDTO updateJogador(@PathVariable Long id, @RequestBody Jogador jogador){
        return new JogadorDTO(jogadorService.updateJogador(id, jogador));
    }


}
