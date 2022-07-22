package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.request.PosicaoRequestDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.service.PosicaoService;
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
@RequestMapping("/posicoes")
@AllArgsConstructor
public class PosicaoController {
    final PosicaoService posicaoService;

    @ApiOperation(value = "Salva uma Posição")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PostMapping()
    public ResponseEntity<Posicao> savePosicao(@RequestBody @Valid PosicaoRequestDTO posicaoRequestDTO) {
        Posicao posicao = getPosicao(posicaoRequestDTO);
        Posicao posicaoSalva = posicaoService.savePosicao(posicao);

        return ResponseEntity.status(HttpStatus.CREATED).body(posicaoSalva);
    }


    @ApiOperation(value = "Lista todas as Posições")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping()
    public ResponseEntity<List<Posicao>> findALL(){
        return ResponseEntity.ok().body(posicaoService.findAll());
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
    public ResponseEntity<Posicao> findById(@PathVariable ("id") Long id){
        return ResponseEntity.ok().body(posicaoService.findById(id));
    }
    private Posicao getPosicao(PosicaoRequestDTO posicaoRequestDTO) {
        Posicao posicao = new Posicao();
        List<Jogador> jogadores = new ArrayList<>();
        BeanUtils.copyProperties(posicaoRequestDTO,posicao);
        BeanUtils.copyProperties(posicaoRequestDTO.getJogadores(),jogadores);
        posicao.setJogadores(jogadores);
        return posicao;
    }
}
