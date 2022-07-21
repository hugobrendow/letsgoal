package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.*;
import br.com.letscode.letsgoal.service.LetsClubeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/letsClubes")
public class LetsClubeController {

    final LetsClubeService letsClubeService;

    @ApiOperation(value = "getGreeting")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista")})

    @GetMapping
    public List<LetsClube> findAll() {
        return letsClubeService.findAll();
    }

    @PostMapping
    public LetsClube saveLetsClube(@RequestBody LetsClube letsClube) {
        return letsClubeService.saveLetsClube(letsClube);
    }

    @GetMapping("/{id}")
    public LetsClube findById(@PathVariable Long id, LetsClube letsClube) {

        return letsClubeService.findById(id);
    }

    @PutMapping("/{id}")
    public LetsClube updateLetsClube(@PathVariable Long id,
                                     @RequestBody LetsClube letsClube) {
        return letsClube;
    }
//    @GetMapping("/{id}")
//    public Jogador buyJogador(@PathVariable Long id, Jogador jogador){
//        return jogador;
//
//    }
}
