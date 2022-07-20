package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.error.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Posicao;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/formacoes")
public class FormacaoController {
    @ApiOperation(value = "getGreeting")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping
    public List<Formacao> findAll() {
        Posicao posicao = new Posicao();
        posicao.setNome("GOLEIRO");
        Formacao formacao = new Formacao(1l, "4-3-3", Arrays.asList(posicao));
        return Arrays.asList(formacao);
    }

    @PostMapping
    public Formacao saveFormacao(@RequestBody Formacao formacao) {
        // SERVIÇO - REGRA DE NEGÓCIO
        return formacao;
    }

    @GetMapping("/{id}")
    public Formacao findById(@PathVariable Long id) {
        Posicao posicao = new Posicao();
        posicao.setNome("GOLEIRO");
        Formacao formacao = new Formacao(id, "4-3-3", Arrays.asList(posicao));
        return formacao;
    }

}
