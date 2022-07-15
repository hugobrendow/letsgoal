package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.DTO.FormacaoDTO;
import br.com.letscode.letsgoal.model.ClassErrors.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.service.FormacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/formacoes")
public class FormacaoController {

    private final FormacaoService formacaoService;


    public FormacaoController(FormacaoService formacaoService, ModelMapper modelMapper) {
        this.formacaoService = formacaoService;
    }

    @ApiOperation(value = "getGreeting")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })


    @GetMapping
    public ResponseEntity<List<FormacaoDTO>> findAll() {
        var listFormacao = formacaoService.findAll();
        return ResponseEntity.ok(listFormacao);
    }

    @PostMapping
    public FormacaoDTO saveFormacao(@RequestBody FormacaoDTO formacaoDTO) {
        return formacaoService.saveFormacao(formacaoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormacaoDTO> findById(@PathVariable Long id) {
        var formacao = formacaoService.findById(id);
        return ResponseEntity.ok(formacao);
    }

}
