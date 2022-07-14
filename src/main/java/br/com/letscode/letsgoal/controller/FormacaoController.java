package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.FormacaoDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.service.FormacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/formacoes")
@AllArgsConstructor
public class FormacaoController {
    private final FormacaoService formacaoService;
    @ApiOperation(value = "Salva uma Formação")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PostMapping
    public FormacaoDTO saveFormacao(@RequestBody Formacao formacao) {
        return new FormacaoDTO(formacaoService.saveFormacao(formacao));
    }
    @ApiOperation(value = "Lista todas as Formações")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping
    public List<FormacaoDTO> findAll() {
        List<FormacaoDTO> formacoesDTO = new ArrayList<>();
        formacaoService.findAll()
                .forEach(formacao -> {formacoesDTO.add(new FormacaoDTO(formacao));});
        return formacoesDTO;
    }
    @ApiOperation(value = "Lista a Formação com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping("/{id}")
    public FormacaoDTO findById(@PathVariable Long id) {
        return new FormacaoDTO(formacaoService.finfById(id));
    }

}
