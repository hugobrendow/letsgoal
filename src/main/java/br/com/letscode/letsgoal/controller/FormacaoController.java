package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.service.FormacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/formacoes")
public class FormacaoController {

    final FormacaoService formacaoService;

    @ApiOperation(value = "getGreeting")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista")})
    @GetMapping
    public List<Formacao> findAll() {
        return formacaoService.findAll();
    }

    @PostMapping
    public Formacao saveFormacao(@RequestBody Formacao formacao) {
        // SERVIÇO - REGRA DE NEGÓCIO
        return formacaoService.saveFormacao(formacao);
    }

    @GetMapping("/{id}")
    public Formacao findById(@PathVariable Long id) {
        return formacaoService.findById(id);
    }

}
