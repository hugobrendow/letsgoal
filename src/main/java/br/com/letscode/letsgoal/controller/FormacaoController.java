package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.FormacaoDTO;
import br.com.letscode.letsgoal.dto.PosicaoDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.service.FormacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/formacoes")
public class FormacaoController {

    final FormacaoService formacaoService;

    @ApiOperation(value = "Salvar Formação")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista")})

    @GetMapping
    public ResponseEntity<List<Formacao>> findAll() {
        return ResponseEntity.ok().body(formacaoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Formacao> save(@RequestBody @Valid FormacaoDTO formacaoDTO) {
        Formacao formacao = new Formacao();
        List<Posicao> posicoes = new ArrayList<>();
        BeanUtils.copyProperties(formacaoDTO, formacao);
        for (PosicaoDTO posicaoDTO: formacaoDTO.getPosicoes() ) {
            Posicao posicao = new Posicao();
            BeanUtils.copyProperties(posicaoDTO , posicao);
            posicoes.add(posicao);
        }
        formacao.setPosicoes(posicoes);
        Formacao formacaoSalva = formacaoService.save(formacao);
        formacaoService.save(formacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(formacaoSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formacao> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(formacaoService.findById(id));
    }

}
