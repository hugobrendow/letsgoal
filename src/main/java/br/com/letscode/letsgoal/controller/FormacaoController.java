package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.FormacaoDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.service.FormacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/formacoes")
public class FormacaoController {

    final private FormacaoService formacaoService;

    public FormacaoController(FormacaoService formacaoService) {
        this.formacaoService = formacaoService;
    }


    @ApiOperation(value = "get formacoes")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping
    public ResponseEntity<List<Formacao>> listar() {

        return ResponseEntity.ok().body(formacaoService.listar());
    }

    @PostMapping
    public ResponseEntity<Formacao> salvar(@RequestBody @Valid FormacaoDTO formacaoDTO) {

        Formacao formacao = new Formacao();
        Posicao posicao = new Posicao();
        BeanUtils.copyProperties(formacaoDTO, formacao);
        BeanUtils.copyProperties(formacaoDTO.getPosicoes(), posicao);
        formacao.setPosicoes(Arrays.asList(posicao));
        Formacao formacaoSalva = formacaoService.salvarFormacao(formacao);
        return null;
    }

    @GetMapping("/{id}")
    public Formacao buscarPorId(@PathVariable Long id) {
        Posicao posicao = new Posicao();
        posicao.setNome("GOLEIRO");
        Formacao formacao = new Formacao(id, "4-3-3", Arrays.asList(posicao));
        return formacao;
    }

}
