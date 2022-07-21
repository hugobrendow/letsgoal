package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.service.JogadorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    final JogadorService jogadorService;
    @ApiOperation(value = "getGreeting")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista")})
    @GetMapping
    public List<Jogador> findAll() {

        return jogadorService.findAll();
    }
    @PostMapping
    public Jogador saveJogador(@RequestBody Jogador jogador){
        return jogadorService.savejogador(jogador);
    }

    @GetMapping("/{id}")
    public Jogador findById(@PathVariable Long id){
        return jogadorService.findById(id);

    }@PutMapping("/{id}")
    public Jogador updateJogador(@PathVariable Long id,
                                           @RequestBody Jogador jogador) {
        return jogador;
    }



}
