package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Mercado;
import br.com.letscode.letsgoal.service.MercadoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/mercados")
public class MercadoController {
    final MercadoService mercadoService;
    @ApiOperation(value = "getGreeting")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista")})
    @GetMapping
    public List<Mercado> viewStatus(Mercado status) {
        return (List<Mercado>) status;
    }

    @GetMapping("/{id}")
    public Mercado findById(@PathVariable Long id, @RequestBody Mercado mercado) {
        return mercadoService.findById(id);
    }

    @PutMapping("/{id}")
    public Mercado updateMercado(@PathVariable Long id,
                                      @RequestBody Mercado mercado) {
        return mercado;
    }

}
