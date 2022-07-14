package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.LetsClubeDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.service.LetsClubeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/letsClubes")
@AllArgsConstructor
public class LetsClubeController {
    final LetsClubeService letsClubeService;

    @ApiOperation(value = "Lista todos os Let's Clubes")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping
    public List<LetsClubeDTO> findAll() {
        List<LetsClubeDTO> letsClubesDTO= new ArrayList<>();
        letsClubeService.findAll()
                .forEach(letsClube -> {letsClubesDTO.add(new LetsClubeDTO(letsClube));});
        return letsClubesDTO;
    }

    @ApiOperation(value = "Salva um Let's Clube")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PostMapping
    public LetsClubeDTO saveLetsClube(@RequestBody LetsClube letsClube) {
        return new LetsClubeDTO(letsClubeService.saveLetsClub(letsClube)) ;
    }

    @ApiOperation(value = "Lista um Let's Clube com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping("/{id}")
    public LetsClubeDTO findById(@PathVariable Long id) {
        return new LetsClubeDTO(letsClubeService.findByID(id));
    }

    @ApiOperation(value = "Atualiza um Let's Clube com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PutMapping("/{id}")
    public LetsClubeDTO updateLetsClube(@PathVariable Long id,
                                           @RequestBody LetsClube letsClube) {
        return new LetsClubeDTO(letsClubeService.updateLetsClub(id,letsClube));
    }

}
