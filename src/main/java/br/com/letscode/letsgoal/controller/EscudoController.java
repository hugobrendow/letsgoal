package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.EscudoDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.service.EscudoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/escudos")
@AllArgsConstructor
public class EscudoController {

    private final EscudoService escudoService;

    @ApiOperation(value = "Salva um Escudo")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PostMapping
    public EscudoDTO saveEscudo(@RequestBody Escudo escudo) {
        return new EscudoDTO(escudoService.saveEscudo(escudo));
    }

    @ApiOperation(value = "Lista todos os Escudos")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping
    public List<EscudoDTO> findAll(){
        List<EscudoDTO> escudosDTO = new ArrayList<>();
        escudoService.findAll()
                .forEach(escudo -> {escudosDTO.add(new EscudoDTO(escudo));});
        return escudosDTO;
    }

    @ApiOperation(value = "Lista o Escudo com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping("/{id}")
    public EscudoDTO findById(@PathVariable Long id){
        return new EscudoDTO(escudoService.findByID(id));
    }

    @ApiOperation(value = "Atualiza o Escudo com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PutMapping("/{id}")
    public EscudoDTO updateEscudo(@PathVariable Long id, @RequestBody Escudo escudo){
        return new EscudoDTO( escudoService.updateEscudo(id, escudo));
    }



}
