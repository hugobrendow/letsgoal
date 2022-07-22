package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.PosicaoDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.service.PosicaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posicao")
public class PosicaoController {
    final PosicaoService posicaoService;
    @ApiOperation(value = "Salvar Posicao")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Posicao.class, responseContainer = "Lista")})


    @GetMapping
    public List<Posicao> findAll() {
        return posicaoService.findAll();
    }

    @PostMapping
    public ResponseEntity<Posicao> save(@RequestBody PosicaoDTO posicaoDTO) {
        Posicao posicao = new Posicao();
        BeanUtils.copyProperties(posicaoDTO, posicao);
        Posicao posicaoSalva = posicaoService.save(posicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(posicaoSalva);
    }
}
