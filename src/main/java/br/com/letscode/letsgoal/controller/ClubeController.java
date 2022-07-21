package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.service.ClubeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clubes")
public class ClubeController {
    final ClubeService clubeService;
    @ApiOperation(value = "getGreeting")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista")})

    @GetMapping
    public List<Clube> findAll() {
        return clubeService.findAll();
    }

    @PostMapping
    public Clube saveClube(@RequestBody Clube clube) {
        return clubeService.saveClube(clube);
    }

    @GetMapping("/{id}")
    public Clube findById(@PathVariable Long id) {

        return clubeService.findById(id);
    }

    @PutMapping("/{id}")
    public Clube updateClube(@PathVariable Long id,
                             @RequestBody Clube clube) {
        return clube;
    }

}
