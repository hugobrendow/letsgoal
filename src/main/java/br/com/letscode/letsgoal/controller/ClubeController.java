package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.ClubeDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.service.ClubeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clubes")
@AllArgsConstructor
public class ClubeController {
    private final ClubeService clubeService;

    @ApiOperation(value = "Salva um Clube")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PostMapping
    public ClubeDTO saveClube(@RequestBody Clube clube){ return new ClubeDTO(clubeService.saveClube(clube)); }
    @ApiOperation(value = "Lista todos os Clubes")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })@GetMapping
    public List<ClubeDTO> findAll(){
        List<ClubeDTO> clubesDTO = new ArrayList<>();
        clubeService.findAll()
                .forEach(clube -> {
                    clubesDTO.add(new ClubeDTO(clube));
                });
        return clubesDTO;
    }
    @ApiOperation(value = "Lista o Clube com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping("/{id}")
    public ClubeDTO findById(@PathVariable Long id){
        return new ClubeDTO(clubeService.findById(id));
    }

    @ApiOperation(value = "Atualiza o Clube com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })@PutMapping("/{id}")
    public ClubeDTO updateClube(@PathVariable Long id, @RequestBody Clube clube){
        return new ClubeDTO(clubeService.updateClube(id, clube));
    }
}
