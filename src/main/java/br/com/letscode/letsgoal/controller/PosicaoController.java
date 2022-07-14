package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.PosicaoDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.service.PosicaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posicoes")
@AllArgsConstructor
public class PosicaoController {
    final PosicaoService posicaoService;

    @ApiOperation(value = "Lista todas as Posições")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping()
    public List<PosicaoDTO> findALL(){
        List<PosicaoDTO>posicoesDTO = new ArrayList<>();
        posicaoService.findAll()
                .forEach(posicao -> {posicoesDTO.add(new PosicaoDTO(posicao));});
        return posicoesDTO;
    }
    @ApiOperation(value = "Salva uma Posição")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PostMapping()
    public PosicaoDTO savePosicao(@RequestBody Posicao posicao){
        return new PosicaoDTO(posicaoService.savePosicao(posicao));
    }
    @ApiOperation(value = "Lista uma Posição com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping("/{id}")
    public PosicaoDTO findById(@PathVariable Long id){
        return new PosicaoDTO(posicaoService.findById(id));
    }
}
