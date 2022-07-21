package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.service.EscudoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/escudos")
public class EscudoController {
    final EscudoService escudoService;
    @ApiOperation(value = "getGreeting")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista")})
    @GetMapping
    public List<Escudo> findAll() {
        return escudoService.findAll();
    }

    @PostMapping
    public Escudo saveEscudo(@RequestBody Escudo escudo) {
        return escudoService.saveEscudo(escudo);
    }

    @GetMapping("/{id}")
    public Escudo findById(@PathVariable Long id) {

        return escudoService.findById(id);
    }

    public Escudo updateEscudo(@PathVariable Long id, @RequestBody Escudo escudo) {
        return escudo;
    }
}
