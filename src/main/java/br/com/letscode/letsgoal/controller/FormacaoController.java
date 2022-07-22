package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.request.FormacaoRequestDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.service.FormacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Formacao> saveFormacao(@RequestBody @Valid FormacaoRequestDTO formacaoRequestDTO) {
        Formacao formacao = getFormacao(formacaoRequestDTO);
        Formacao formacaoSalva = formacaoService.saveFormacao(formacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(formacaoSalva);
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
    public ResponseEntity<List<Formacao>>findAll() {
        return ResponseEntity.ok().body(formacaoService.findAll());
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
    public ResponseEntity<Formacao> findById(@PathVariable ("id") Long id) {
        return ResponseEntity.ok().body(formacaoService.finfById(id));
    }
    private Formacao getFormacao(FormacaoRequestDTO formacaoRequestDTO) {
        Formacao formacao = new Formacao();
        List<Posicao> posicoes = new ArrayList<>();
        BeanUtils.copyProperties(formacaoRequestDTO, formacao);
        BeanUtils.copyProperties(formacaoRequestDTO.getPosicoes(), posicoes);
        formacao.setPosicoes(posicoes);
        return formacao;
    }

}
